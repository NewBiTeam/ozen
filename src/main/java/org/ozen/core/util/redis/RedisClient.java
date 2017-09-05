package org.ozen.core.util.redis;
import java.util.List;
import java.util.Map;

public interface RedisClient {
	/**
	 * 给缓存中名称为key的string赋予值value
	 * @param key
	 * @param value
	 */
    void set(String key, String value);
    
    /**
     * 给缓存中名称为key的string赋予值value,并设置过期时间
     * @param key
     * @param value
     * @param seconds
     */
    void setKeyTimeout(String key, String value, int seconds);
    
    /**
     * 名称为key的string的值附加value
     * @param key
     * @param value
     */
    void append(String key, String value);
    
    /**
     * 名称为key的string的值,seconds秒后过期
     * @param key
     * @param seconds
     */
    void setExpired(String key, int seconds);
    
    /**
     * 批量返回名称为key的string的value
     * @param keys
     * @return
     */
    List<String> mget(String...keys);
    
    /**
     * 批量删除名为key的value
     * @param keys
     */
    void del(String...keys);
    
    /**
     * 返回名称为key的string的value
     * @param key
     * @return
     */
    String get(String key);
    
    /**
     * 返回满足给定pattern的key
     * @param pattern
     * @return
     */
    String getKey(String pattern);
    
    /**
     * 返回满足给定pattern的所有key
     * @param pattern
     * @return
     */
    String[] getKeys(String pattern);
    
    /**
     * 删除pattern的所有key
     * @param pattern
     */
    void delKeys(String pattern);
    
    /**
     * 名key的值+1
     * @param key
     */
    void incr(String key);
    
    /**
     * 名key的值加value
     * @param key
     */
    void increaseBy(String key, String value);
    
    /**
     * 名key的值-1
     * @param key
     */
    void decr(String key);
    
    /**
     * 名key的值减value
     * @param key
     * @param value
     */
    void decrBy(String key, String value);

    /**
     * 删除区间以外的数据  
     */
    String ltrim(String key, String start, String end);
    
    /**
     * 删除列表指定下标的值
     */
    long lrem(String key, String count, String value);
    /**
     * 判断名为key的存在
     * @param key
     * @return
     */
    boolean exists(String key);
    
    /**
     * 给缓存key里添加一个member成员
     * @param key
     * @param member
     */
    void sSet(String key, String member);
    /**
     * 给缓存key里删除一个member成员
     * @param key
     * @param member
     */
    void sDel(String key, String member);
    
	/**
	 * @param key
	 * @param member
	 * @return true 存在，false不存在
	 */
    Boolean sIsMember(String key, String member);
    
    /**
     * 获取key里所有的成员
	 * @param key
	 * @param member
	 * @return true 存在，false不存在
	 */
    String[] sMembers(String key);
    
    /**
     * 获取key过期剩余时间
     * @param key
     * @return
     */
    long getKeyExpired(String key);
    // 返回集合的元素个数
    long scard(String key);
    
    // list
    // 添加数据  
    void rpush(String key, String value);
    // 列表出栈 
    String lpop(String key);
    // 数组长度
    long llen(String key);
    // 整个列表值  
    List<String> lrange(String key, String start, String end);
    // 升序
    List<String> sort(String key);
    List<String> sortDesc(String key);
    
    // hash
    Map<String, String> hGetAll(String key);
    String hGet(String key, String field);
    // 获取指定的值  
    List<String> hMGet(String key, String...fields);
    void hMSet(String key, Map<String, String> map);
    // 为key中的域 field 的值加上增量 increment 
    void hIncrease(String key, String field, String value);
    // 为key中的域 field 的值加上增量 increment 
    long hIncrBy(String key, String field, String value);
    // 删除指定的值  
    void hDel(String key, String...fields);
    boolean hexists(String key, String field);
}