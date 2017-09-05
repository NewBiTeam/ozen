package org.ozen.core.util;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * commons-email-1.4.jar 发送邮件工具
 * 
 * @author zxy 2017年8月31日 00:01:11
 */
public class EmailUtil {

	/**
	 * 发送基本(普通)邮件： 发送邮箱 --用户名：zhaoxny@163.com --第三方登录密码：zxy9410（邮箱可设置客户端授权密码）
	 * 
	 */
	public static void sendSimpleEmail() {
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.163.com"); // 设置发送端服务器
		simpleEmail.setSmtpPort(25);
		simpleEmail.setAuthentication("zhaoxny@163.com", "zxy9410"); // 用户名和密码
		simpleEmail.setCharset("UTF-8"); // 设置字符集
		simpleEmail.setSSLOnConnect(true); // gmail邮箱必须设置为true
		try {
			simpleEmail.setFrom("zhaoxny@163.com", "系统邮箱", "UTF-8"); // 发件人[邮箱，显示名称，转换格式]
			simpleEmail.addTo("347910189@qq.com", "收件人"); // 收件人1 昵称是对别人显示的，
			simpleEmail.addTo("453973097@qq.com", "哈哈"); // 收件人2
			// simpleEmail.addCc("test@gmail.com", "test"); // 抄送
			// simpleEmail.addBcc("test@sina.com", "test"); // 密送
			simpleEmail.setSubject("测试简单邮件"); // 主题
			simpleEmail.setMsg("这里是测试简单邮件内容11"); // 发送内容
			simpleEmail.send();
			System.out.println("success!");
		} catch (EmailException e) {
			System.out.println("failure!");
			e.printStackTrace();
		}
	}

	/**
	 *  发送文本格式，带附件邮件
	 */
	public static void sendMultiPartEmail() {
		MultiPartEmail multiPartEmail = new MultiPartEmail();
		multiPartEmail.setHostName("smtp.163.com"); // 设置发送端服务器
		multiPartEmail.setSmtpPort(25);
		multiPartEmail.setAuthentication("zhaoxny@163.com", "zxy9410"); // 用户名和密码
		multiPartEmail.setCharset("UTF-8"); // 设置字符集
		multiPartEmail.setSSLOnConnect(true); // gmail邮箱必须设置为true
		try {
			multiPartEmail.setFrom("zhaoxny@163.com", "系统邮箱", "UTF-8"); // 发件人
			multiPartEmail.addTo("347910189@qq.com", "收件人");// 收件人1
//			multiPartEmail.addTo("453973097@qq.com", "哈哈");
			multiPartEmail.setSubject("----"); // 主题
			multiPartEmail.setMsg("---"); // 发送内容
			setAttach(multiPartEmail, Arrays.asList("d:/txt.txt")); // 设置附件
			multiPartEmail.send();
			System.out.println("success!");
		} catch (EmailException e) {
			System.out.println("failure!");
			e.printStackTrace();
		}
	}

	/**
	 * 发送HTML格式带附件邮件
	 */
	public static void sendHtmlEmail() {
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName("smtp.163.com"); // 设置发送端服务器
		htmlEmail.setSmtpPort(25);
		htmlEmail.setAuthentication("zhaoxny@163.com", "zxy9410"); // 用户名和密码
		htmlEmail.setCharset("UTF-8"); // 设置字符集
		htmlEmail.setSSLOnConnect(true); // gmail邮箱必须设置为true
		try {
			htmlEmail.setFrom("zhaoxny@163.com", "则", "UTF-8"); // 发件人
			htmlEmail.addTo("347910189@qq.com", "收件人");
			htmlEmail.setSubject("不在网易允许的发信用户列表里"); // 主题
			URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			String cid = htmlEmail.embed(url, "Apache logo");
			htmlEmail.setHtmlMsg("x"); // 发送内容
//			setAttach(htmlEmail, Arrays.asList("d:/txt.txt")); // 设置附件
			htmlEmail.send();
			System.out.println("success!");
		} catch (Exception e) {
			System.out.println("failure!");
			e.printStackTrace();
		}
	}

	/**
	 * 设置附件
	 * 
	 * @param email
	 * @param list
	 * @throws EmailException
	 */
	public static void setAttach(MultiPartEmail email, List<String> list) throws EmailException {
		for (String aPath : list) {
			String aName = aPath.substring(aPath.lastIndexOf("/") + 1, aPath.length());
			EmailAttachment attach = new EmailAttachment();
			attach.setName(aName); // 设置附件名
			attach.setDisposition(EmailAttachment.ATTACHMENT);
			attach.setDescription("attach");
			attach.setPath(aPath); // 设置附件路径
			// attach.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			email.attach(attach);
		}
	}

	public static void main(String[] args) {
//		sendSimpleEmail();
//		sendMultiPartEmail();
		sendHtmlEmail();
	}
}
