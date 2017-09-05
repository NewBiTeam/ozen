package org.ozen.core.util;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class JsonUtil {
	/**
	 * 从普通的Bean转换为字符串
	 * @param o
	 * @return
	 */
	public static String getJson(Object o) {
		JSONObject jo = JSONObject.fromObject(o);
		return jo.toString();
	}

	/**
	 * 从Java的列表转换为字符串
	 * @param list
	 * @return
	 */
	public static String getJson(List list) {
		JSONArray ja = JSONArray.fromObject(list);
		return ja.toString();
	}

	/**
	 * 从Java对象数组转换为字符串
	 * @param arry
	 * @return
	 */
	public static String getJson(Object[] arry) {
		JSONArray ja = JSONArray.fromObject(arry);
		return ja.toString();
	}

	/**
	 * 从json格式的字符串转换为Map对象
	 * @param s
	 * @return
	 */
	public static Map getObject(String s) {
		return JSONObject.fromObject(s);
	}

	/**
	 * 从json格式的字符串转换为List数组
	 * @param s
	 * @param z
	 * @return
	 */
	public static List getList(String s, Class z) {
		JSONArray array = JSONArray.fromObject(s);
		return JSONArray.toList(array, z);
	}

	/**
	 * 从json格式的字符串转换为某个Bean
	 * @param s
	 * @param cls
	 * @return
	 */
	public static Object getObject(String s, Class cls) {
		JSONObject jo = JSONObject.fromObject(s);
		return JSONObject.toBean(jo, cls);
	}

	/**
	 * 从json格式的字符串转换为某类对象的数组
	 * @param s
	 * @param cls
	 * @return
	 */
	public static Object getArray(String s, Class cls) {
		JSONArray ja = JSONArray.fromObject(s);
		return JSONArray.toArray(ja, cls);
	}

	public static Object string2obj(String jsonString, Class clazz) {
		if (jsonString == null || "".equals(jsonString))
			return null;
		JSONObject json = JSONObject.fromObject(jsonString);
		Object obj = JSONObject.toBean(json, Map.class);
		return obj;
	}
}