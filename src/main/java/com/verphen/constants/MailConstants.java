/**
 * @author verphen
 * @date 2014年6月10日  上午10:12:35
 */

package com.verphen.constants;

import java.util.HashMap;
import java.util.Map;

public class MailConstants {
	
	/***************** 邮件服务器信息 ******************/
	public static String SMTP = "smtp.qq.com"; /*发送邮件使用的smtp(Simple Message Transfer Protocol 简单邮件传输协议)*/
//	public static String SMTP = "smtp.163.com"; /*发送邮件使用的smtp(Simple Message Transfer Protocol 简单邮件传输协议)*/
	
	public static String  SMTP_HOST = "mail.smtp.host";	/* SMTP 主机 */
	public static String  SMTP_AUTH = "mail.smtp.auth";	/* SMTP 验证 */
	

	/***************** 发件人信息 ******************/
	public static String SENDER_EMAIL = "851474818@qq.com"; /* 邮箱 (必填)*/
	public static String SENDER_USERNAME = "851474818";	/* 登录用户名(必填) */
	public static String SENDER_PASSWD = "*******";	/* 登录密码(必填) */

	/***************** 收件人信息 ******************/
	public static String[] RECEIVED_EMAIL = {"*******@163.com","*****@qq.com"}; /* 收件人邮箱 (必填)*/

	
	/***************** 邮件信息 ******************/
	public static String MIMETYPE = "text/html;charset=utf-8"; /* 邮件内容类型  */
	public static String TITLE = "email title"; /* 发送邮件标题 */
	public static String CONTENT = "email content;<b><a href='#'>test</a></b>";/* 邮件内容(支持html语法) */
	public static Map<String,String> ANNEX = new HashMap<String,String>();	/*邮件附件(key:附件完整路径名；value：附件重新命名)*/
	
	/* 附件 初始化数据 */
	static{
		ANNEX.put("D:\\mail\\1.txt", "1.txt");
		ANNEX.put("D:\\mail\\2.txt", "2.txt");
	}
}
