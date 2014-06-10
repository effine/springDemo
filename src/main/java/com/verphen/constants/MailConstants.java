/**
 * @author verphen
 * @date 2014年6月10日  上午10:12:35
 */

package com.verphen.constants;

import java.util.Map;

public class MailConstants {

	/************* 发件人 ***************/
	/* 发件人邮箱服务器 */
	private String mailHost;

	/* 发件人邮箱 */
	private String mailFrom;

	/* 发件人用户名 */
	private String mailUserName;

	/* 发件邮箱人密码 */
	private String mailPassword;

	/************* 收件人 ***************/
	/* 收件人邮箱；多个用分号“；”隔开 */
	private String toMails;

	/* 邮件主题 */
	private String subject;

	/* 邮件内容 */
	private String content;

	/* 邮件中的图片，为空时无图片。map中的key为图片ID，value为图片地址 */
	private Map<String, String> pictures;

	/* 邮件中的附件，为空时无附件。map中的key为附件ID，value为附件地址 */
	private Map<String, String> attachments;

}
