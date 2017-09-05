package org.ozen.core.util.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@SuppressWarnings("unchecked")
@Service("redisClient")
public class RedisClientImpl extends BaseRedisClient implements RedisClient {

	// redis db;
	private int _db;
	// logger.
	@SuppressWarnings("unused")
	private Logger _logger = LoggerFactory.getLogger(RedisClientImpl.class);

	public RedisClientImpl() {
		this._db = 0;// 缓存主库，
	}

	@Override
	public void set(String key, String value) {
		this.execute(RedisActionEnum.SET_VALUE, key, value, null);
	}

	@Override
	public void setKeyTimeout(String key, String value, int seconds) {
		this.execute(RedisActionEnum.SET_VALUE_WITH_TIMEOUT, key, value,
				String.valueOf(seconds));
	}

	@Override
	public void append(String key, String value) {
		this.execute(RedisActionEnum.APPEND_VALUE, key, value);
	}

	@Override
	public void setExpired(String key, int seconds) {
		this.execute(RedisActionEnum.SET_VALUE_EXPIRED, key, null,
				String.valueOf(seconds));
	}

	@Override
	public List<String> mget(String... keys) {
		List<String> result = null;
		Object obj = execute(RedisActionEnum.M_GET, null, null, keys);
		if (obj != null) {
			result = (List<String>) obj;
		}
		return result;
	}

	@Override
	public void del(String... keys) {
		this.execute(RedisActionEnum.DEL_KEYS, null, null, keys);
	}

	@Override
	public String get(String key) {
		String result = null;
		Object obj = this.execute(RedisActionEnum.GET_VALUE_BY_KEY, key, null,
				null);

		if (obj != null) {
			result = (String) obj;
		}
		return result;
	}

	@Override
	public String getKey(String pattern) {

		String result = null;
		Object obj = this.execute(RedisActionEnum.GET_KEY_WITH_PATTEN, null,
				null, pattern);
		if (obj != null) {
			Set<String> value = (Set<String>) obj;
			for (String s : value) {
				result = s;
			}
		}
		return result;
	}

	@Override
	public String[] getKeys(String pattern) {
		String[] result = null;
		Set<String> value = null;
		Object obj = this.execute(RedisActionEnum.GET_KEYS_WITH_PATTEN, null,
				null, pattern);
		if (obj != null) {
			value = (Set<String>) obj;
		}

		if (null != value && value.size() > 0) {
			result = new String[value.size()];
			result = value.toArray(result);
		}
		return result;
	}

	@Override
	public void delKeys(String pattern) {
		this.execute(RedisActionEnum.DEL_KEYS, null, null, pattern);
	}

	@Override
	public void sSet(String key, String member) {
		this.execute(RedisActionEnum.S_ADD, key, null, member);
	}

	@Override
	public void sDel(String key, String member) {
		this.execute(RedisActionEnum.S_DEL, key, null, member);
	}

	@Override
	public Boolean sIsMember(String key, String member) {
		Boolean result = false;
		Object obj = this.execute(RedisActionEnum.S_IS_MEMBER, key, null,
				member);
		if (obj != null) {
			result = (Boolean) obj;
		}
		return result;
	}

	@Override
	public String[] sMembers(String key) {
		String[] result = null;
		Set<String> value = null;
		Object obj = this.execute(RedisActionEnum.S_MEMBERS, key, null, null);
		if (obj != null) {
			value = (Set<String>) obj;
		}
		if (null != value && value.size() > 0) {
			result = new String[value.size()];
			result = value.toArray(result);
		}
		return result;
	}

	@Override
	public void incr(String key) {
		this.execute(RedisActionEnum.INCREASE, key, null, null);
	}

	public void increaseBy(String key, String value) {
		this.execute(RedisActionEnum.INCREASE_BY, key, null, value);
	}

	@Override
	public void decr(String key) {
		this.execute(RedisActionEnum.DECR, key, null, null);
	}

	public void decrBy(String key, String value) {
		this.execute(RedisActionEnum.DECR_BY, key, null, value);
	}

	@Override
	public int getDB() {
		return this._db;
	}

	@Override
	public void hIncrease(String key, String field, String value) {
		this.execute(RedisActionEnum.H_INCREASE, key, null, field, value);
	}

	public Map<String, String> hGetAll(String key) {
		Map<String, String> result = null;
		Object obj = this.execute(RedisActionEnum.H_GETALL, key, null, null);
		if (obj != null) {
			result = (Map<String, String>) obj;
		}
		return result;
	}

	public List<String> hMGet(String key, String... fields) {
		List<String> result = null;
		Object obj = this.execute(RedisActionEnum.H_MGET, key, null, fields);
		if (null != obj) {
			result = (List<String>) obj;
		}
		return result;
	}

	@Override
	public void hDel(String key, String... fields) {
		this.execute(RedisActionEnum.H_DEL, key, null, fields);
	}

	@Override
	public boolean hexists(String key, String field) {
		boolean bool = false;
		Object obj = this.execute(RedisActionEnum.H_EXISTS, key, null, field);
		if (null != obj) {
			bool = (Boolean) obj;
		}
		return bool;
	}

	@Override
	public String hGet(String key, String field) {
		String result = null;
		Object obj = this.execute(RedisActionEnum.H_GET, key, null, field);
		if (null != obj) {
			result = (String) obj;
		}
		return result;
	}

	@Override
	public long hIncrBy(String key, String field, String value) {
		long result = 0;
		Object obj = this.execute(RedisActionEnum.H_INCRBY, key, value, field);
		if (null != obj) {
			result = (Long) obj;
		}
		return result;
	}

	@Override
	public void hMSet(String key, Map<String, String> map) {
		// TODO 暂时使用不到，以后在做json转换
		// String value = JsonUtil.obj2string(map);
		// this.execute(RedisActionEnum.H_MSET, key, "", null);
	}

	@Override
	public boolean exists(String key) {
		boolean result = false;
		Object obj = this.execute(RedisActionEnum.EXISTS, key, null, null);
		if (null != obj) {
			result = (Boolean) obj;
		}
		return result;
	}

	@Override
	public long scard(String key) {
		long result = 0;
		Object obj = this.execute(RedisActionEnum.S_CARD, key, null, null);
		if (null != obj) {
			result = (Long) obj;
		}
		return result;
	}

	@Override
	public void rpush(String key, String value) {
		this.execute(RedisActionEnum.R_PUSH, key, value);
	}

	@Override
	public String lpop(String key) {
		String result = null;
		Object obj = this.execute(RedisActionEnum.L_POP, key, null, null);
		if (obj != null) {
			result = (String) obj;
		}
		return result;
	}

	@Override
	public long llen(String key) {
		Long result = null;
		Object obj = this.execute(RedisActionEnum.L_LEN, key, null, null);
		if (obj != null) {
			result = (Long) obj;
		}
		return result;
	}

	@Override
	public List<String> lrange(String key, String start, String end) {
		List<String> result = null;
		Object obj = this.execute(RedisActionEnum.L_RANGE, key, start, end);
		if (obj != null) {
			result = (List<String>) obj;
		}
		return result;
	}

	@Override
	public long lrem(String key, String count, String value) {
		Long result = null;
		Object obj = this.execute(RedisActionEnum.L_REM, key, count, value);
		if (obj != null) {
			result = (Long) obj;
		}
		return result;
	}

	@Override
	public String ltrim(String key, String start, String end) {
		String result = null;
		Object obj = this.execute(RedisActionEnum.L_TRIM, key, start, end);
		if (obj != null) {
			result = (String) obj;
		}
		return result;
	}

	@Override
	public List<String> sort(String key) {
		List<String> result = null;
		Object obj = this.execute(RedisActionEnum.SORT, key, null, null);
		if (obj != null) {
			result = (List<String>) obj;
		}
		return result;
	}

	@Override
	public List<String> sortDesc(String key) {
		List<String> result = null;
		Object obj = this.execute(RedisActionEnum.SORT_DESC, key, null, null);
		if (obj != null) {
			result = (List<String>) obj;
		}
		return result;
	}

	public long getKeyExpired(String key) {
		Long result = null;
		Object obj = this.execute(RedisActionEnum.TTL, key, null, null);
		if (obj != null) {
			result = (Long) obj;
		}
		return result;
	}
}
