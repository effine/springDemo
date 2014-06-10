/**
 * @author verphen
 * @date 2014年6月10日  上午10:23:23
 */

package com.verphen.model;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Mail implements Serializable {

	private static final long serialVersionUID = -8217931184148747837L;

	/* 发件人邮箱服务器 */
	private String mailHost;

	/* 发件人邮箱 */
	private String mailFrom;

	/* 发件人用户名 */
	private String mailUserName;

	/* 发件邮箱人密码 */
	private String mailPassword;

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

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailUserName() {
		return mailUserName;
	}

	public void setMailUserName(String mailUserName) {
		this.mailUserName = mailUserName;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getToMails() {
		return toMails;
	}

	public void setToMails(String toMails) {
		this.toMails = toMails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, String> getPictures() {
		return pictures;
	}

	public void setPictures(Map<String, String> pictures) {
		this.pictures = pictures;
	}

	public Map<String, String> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, String> attachments) {
		this.attachments = attachments;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
