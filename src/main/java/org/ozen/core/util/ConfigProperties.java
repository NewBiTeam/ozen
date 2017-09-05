package org.ozen.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取Config.Properties的配置文件
 * 
 * @author zxy
 *
 */
public class ConfigProperties {
	private static Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
	private static Properties prop = null;
	static {
		prop = new Properties();
		InputStream in = getPath("config.properties");
		if (in == null) {
			logger.debug("config.properties is null");
		}
		try {
			prop.load(in);
		} catch (IOException e) {
			logger.debug("ConfigProperties:{}", e.getMessage());
		}
	}

	/**
	 * 私有构造方法，不需要创建对象
	 */
	private ConfigProperties() {
	}

	/**
	 * 获取文件中 “key”属性的内容
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		String value = "";
		if (StringUtil.isBlank(key)) {
			logger.debug("ConfigProperties:key is null");
		} else {
			value = prop.getProperty(key).trim();
		}
		return value;
	}

	/**
	 * 获取config.properties的路径
	 * @param path	文件名：config.properties
	 * @return
	 */
	private static InputStream getPath(String path) {
		File fDir = new File(ConfigProperties.class.getResource("/").getPath());
		String p = fDir.getAbsolutePath();
		path = p.replace("\\", "/") + "/" + path;
		logger.debug("config.properties path:{}", path);
		try {
			InputStream is;
			is = new FileInputStream(path);
			return is;
		} catch (FileNotFoundException e) {
			logger.debug("config.properties is null;patn:{}", path);
			e.printStackTrace();
		}
		return null;
	}
	

	public static void main(String[] args) {
		String token = ConfigProperties.getProperty("token");
		System.out.println(token);
	}
}
