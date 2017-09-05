package org.ozen.core.util;


/**
 * 综合
 * @author Administrator
 *
 */
public class Constants {
	
	/** 存入session的用户信息 */
	public static final String SESSION_LOGIN_USER = "SESSION_LOGIN_USER";
	
	/** 上传类型 **/
	public enum uploadType {
		album("album"),
		img("img"),
		voice("voice"),
		video("video"),
		domain("domain");

		private final String value;

		uploadType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	
	/**  **/
}