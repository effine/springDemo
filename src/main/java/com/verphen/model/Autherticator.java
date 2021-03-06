/**
 * @author verphen
 * @date 2014年6月11日  下午1:50:58
 */

package com.verphen.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autherticator extends Authenticator {
	private String username;
	private String passwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Autherticator(String username, String passwd) {
		super();
		setUsername(username);
		setPasswd(passwd);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, passwd);
	}
}
