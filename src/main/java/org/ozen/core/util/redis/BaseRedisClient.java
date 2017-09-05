package org.ozen.core.util.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.ozen.core.util.ConfigProperties;
import org.ozen.core.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SortingParams;

enum RedisActionEnum {
    SET_VALUE,
    SET_VALUE_WITH_TIMEOUT,
    APPEND_VALUE,
    SET_VALUE_EXPIRED,
    M_GET,
    DEL_VALUE_WITH_MULTI_KEYS,
    GET_VALUE_BY_KEY,
    GET_KEY_WITH_PATTEN,
    GET_KEYS_WITH_PATTEN,
    DEL_KEYS,
    INCREASE,
    INCREASE_BY,
    DECR,
    DECR_BY,
    
    H_INCREASE,
    H_GETALL,
    H_MGET,
    H_DEL,
    H_EXISTS,
    H_GET,
    H_INCRBY,
    H_MSET,
    EXISTS,
    S_CARD,
    S_ADD,
    S_DEL,
    S_IS_MEMBER,
    S_MEMBERS,
    
    R_PUSH,
    L_POP,
    L_LEN,
    L_RANGE,
    L_REM,
    L_TRIM,
    SORT,
    SORT_DESC,
    TTL
}

public abstract class BaseRedisClient {

    private Logger _logger = LoggerFactory.getLogger(BaseRedisClient.class);

    protected abstract int getDB();
    
	// Redis服务器IP
	private static String server;

	// Redis的端口号
	private static short port;

	// 超时时间
	private static int timeout;

	// 访问密码
	private static String password;

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int maxActive;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int maxIdle;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int maxWait;

	private static boolean testOnBorrow = true;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private JedisPool clientPool = null;

    @SuppressWarnings("static-access")
	protected BaseRedisClient() {

        this.server = ConfigProperties.getProperty("redisServer");
        this.port =Short.parseShort(ConfigProperties.getProperty("redisPort"));
        this.timeout = Integer.parseInt(ConfigProperties.getProperty("redisTimeout"));
        this.password = ConfigProperties.getProperty("redisPwd");
        this.maxActive = Integer.parseInt(ConfigProperties.getProperty("redisMaxActive"));
        this.maxIdle = Integer.parseInt(ConfigProperties.getProperty("redisMaxIdle"));
        this.maxWait =  Integer.parseInt(ConfigProperties.getProperty("redisMaxWait"));
        if(clientPool == null)
        {
            _logger.debug("ready to connect to redis server {} on {}", server, port);
			try {
				JedisPoolConfig config = new JedisPoolConfig();
				config.setMaxTotal(maxActive);
				config.setMaxIdle(maxIdle);
				config.setMaxWaitMillis(maxWait);
				config.setTestOnBorrow(testOnBorrow);
				// clientPool = new JedisPool(config, server, port);
				clientPool = new JedisPool(config, server, port, timeout,
						password);
				_logger.trace("redis connected");
			} catch (Exception e) {
				_logger.error("exception raised with message: {}",
						e.getMessage());
			}
        }
        else
        {
            _logger.trace("redis client has connected to server!");
        }
    }

    @SuppressWarnings("unused")
	private Jedis getRedisClient() {

        Jedis client;
        client = clientPool.getResource();

        if (client.getDB() == null || client.getDB().intValue() != this.getDB()) {
            _logger.trace("switch to new db, {}, {}", client.getDB(), this.getDB());
            client.select(this.getDB());
        } else {
            _logger.debug("using existence db.");
        }

        if (client==null) {
            _logger.error("redis client is null.");
        }

        return client;
    }

    private void returnResource(Jedis client) {
        if (client != null) {
            clientPool.returnResource(client);
            _logger.trace("return resource to pool." );
        } else {
            _logger.error("redis client is null...");
        }
    }

    private int getIntValueFromParamters(int index, String...params) {
        int result = 0;
        if (params == null) {
            _logger.error("parameters is empty.");
        } else {
            String str = params[index];
            result = Integer.valueOf(str).intValue();
        }
        return result;
    }

    private float getFloatValueFromParameters(int index, String...params) {
        float result = 0;
        if (params == null) {
            _logger.error("parameters is empty.");
        } else {
            String str = params[index];
            str = str.replace("\\n", "");
            result = Float.valueOf(str).floatValue();
        }
        return result;
    }


    private long getLongValueFromParameters(int index, String...params) {
        long result = 0;
        if (params == null) {
            _logger.error("parameters is empty.");
        } else {
            String str = params[index];
            str = str.replace("\\n", "");
            result = Long.valueOf(str);
        }
        return result;
    }



    private String getStringValueFromParameters(int index, String...params) {
        return params[index];
    }

    @SuppressWarnings("unchecked")
	protected  Object execute(RedisActionEnum action, String key, String value, String...params) {
        Object result = null;
        Jedis client = null;
        try {
            client = this.getRedisClient();
            //_logger.debug("action: {}, set {} value {}", action, key, value);
            if (client == null) {
                return result;
            }

            switch (action) {
                case SET_VALUE: {
                    client.set(key, value);
                    break;
                }

                case SET_VALUE_WITH_TIMEOUT: {
                    int seconds = this.getIntValueFromParamters(0, params);
                    client.setex(key, seconds, value);
                    break;
                }

                case APPEND_VALUE:
                    client.append(key, value);
                    break;

                case SET_VALUE_EXPIRED: {
                    int seconds = this.getIntValueFromParamters(0, params);
                    client.expire(key, seconds);
                    break;
                }

                case M_GET: {
                    result = client.mget(params);
                    break;
                }

                case DEL_VALUE_WITH_MULTI_KEYS: {
                    client.del(params);
                    break;
                }

                case GET_VALUE_BY_KEY: {
                    result = client.get(key);
                    break;
                }

                case GET_KEY_WITH_PATTEN: {
                    String patten = this.getStringValueFromParameters(0, params);
                    result = client.keys(patten);
                    break;
                }

                case GET_KEYS_WITH_PATTEN: {
                    String patten = this.getStringValueFromParameters(0, params);
                    result = client.keys(patten);
                    break;
                }

                case DEL_KEYS: {
                    String patten = this.getStringValueFromParameters(0, params);
                    Set<String> keys = client.keys(patten);
                    if (null != keys) {
                        for (String k: keys) {
                            client.del(k);
                        }
                    }
                    break;
                }
                case S_ADD: {
                    String member = this.getStringValueFromParameters(0, params);
                    client.sadd(key, member);
                    break;
                }

                //Remove the specified member from the set value stored at key.
                case S_DEL: {
                    String member = this.getStringValueFromParameters(0, params);
                    client.srem(key, member);
                    break;
                }

                case S_IS_MEMBER: {
                    String member = this.getStringValueFromParameters(0, params);
                    result = client.sismember(key, member);
                    break;
                }

                case S_MEMBERS: {
                    result = client.smembers(key);
                    break;
                }
                case INCREASE: {
                    client.incr(key);
                    break;
                }
                case INCREASE_BY: {
                    client.incrBy(key, this.getLongValueFromParameters(0, params));
                }
                case DECR: {
                    client.decr(key);
                    break;
                }
                case DECR_BY: {
                    client.decrBy(key, this.getLongValueFromParameters(0, params));
                    break;
                }
                case H_INCREASE:{
                    String field = this.getStringValueFromParameters(0, params);
                    float increaseValue = this.getFloatValueFromParameters(1, params);
                    client.hincrBy(key, field, (long) increaseValue);
                    break;
                }
                case H_GETALL: {
                    result = client.hgetAll(key);
                    break;
                }
                case H_MGET: {
                    result = client.hmget(key, params);
                    break;
                }
                case H_DEL: {
                    client.hdel(key, params);
                    break;
                }
                case H_EXISTS: {
                	String field = this.getStringValueFromParameters(0, params);
                	result = client.hexists(key, field);
                    break;
                }
                case H_GET: {
                	String field = this.getStringValueFromParameters(0, params);
                	result = client.hget(key, field);
                    break;
                }
                case H_INCRBY: {
                	String field = this.getStringValueFromParameters(0, params);
                	long hincrbyValue = Long.parseLong(value);
                	result = client.hincrBy(key, field, hincrbyValue);
                    break;
                }
                case H_MSET: {
                	Map<String, String> map = (Map<String, String>) JsonUtil.string2obj(value, (new HashMap<String, String>()).getClass());
                    client.hmset(key, map);
                    break;
                }
                case S_CARD: {
                	result = client.scard(key);
                    break;
                }
                case EXISTS: {
                	result = client.exists(key);
                    break;
                }
                case R_PUSH:{
                    client.rpush(key, value);
                    break;
                }
                case L_POP: {
                    result = client.lpop(key);
                    break;
                }
                case L_LEN:{
                	result = client.llen(key);
                    break;
                }
                case L_REM: {
                	String value2 = this.getStringValueFromParameters(0, params);
                    result = client.lrem(key, Long.parseLong(value), value2);
                    break;
                }
                case L_RANGE:{
                	long value2 = this.getLongValueFromParameters(0, params);
                	result = client.lrange(key, Long.parseLong(value), value2);
                    break;
                }
                case L_TRIM: {
                	long value2 = this.getLongValueFromParameters(0, params);
                    result = client.ltrim(key, Long.parseLong(value), value2);
                    break;
                }
                case SORT: {
                    result = client.sort(key);
                    break;
                }
                case SORT_DESC: {
                	SortingParams sortingParams = new SortingParams();
                    sortingParams.desc();
                    result = client.sort(key,sortingParams);
                    break;
                }
                case TTL: {
                	result=client.ttl(key);
                    break;
                }
                default:
                    _logger.debug("no action.");
            }
        }
        catch(Exception e){
            _logger.error("exception raised: host->{} port->{}", server, port);
            _logger.error("exception raised: msg-> {}", e.getMessage());
        }
        finally {
            this.returnResource(client);
        }
        return result;
    }
}
