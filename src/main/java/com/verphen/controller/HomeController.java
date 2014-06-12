package com.verphen.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/isAutologin")
	@ResponseBody
	public String isAutologin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		boolean flag = false;
		String username = null;
		String password = null;
		Cookie[] cookie = request.getCookies();
		for (Cookie c : cookie) {
			if ("isAutologin".equalsIgnoreCase(c.getName())
					&& "true".equalsIgnoreCase(c.getValue())) {
				flag = true;
			}
		}

		if (flag) {
			for (Cookie c : cookie) {
				if ("username".equalsIgnoreCase(c.getName())) {
					username = c.getValue();
				}

				if ("password".equalsIgnoreCase(c.getName())) {
					password = c.getValue();
				}
			}
			login(username, password, "true", request, response);
		}
		return "false";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password, String isAutologin,HttpServletRequest request,
			HttpServletResponse response) {
		if ("test".equalsIgnoreCase(username)
				&& "test".equalsIgnoreCase(password)) {

			Cookie autologin = new Cookie("isAutologin", isAutologin);
			autologin.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
			response.addCookie(autologin);

			Cookie cookieUsername = new Cookie("username", username);
			cookieUsername.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
			response.addCookie(cookieUsername);

			Cookie cookiePassword = new Cookie("password", password);
			cookieUsername.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
			response.addCookie(cookiePassword);

	/*		String sessionId = session.getId();
			System.out.println("SessionID：" + sessionId);
			Cookie cookieSessionID = new Cookie("sessionID", sessionId);
			cookieSessionID.setMaxAge(60 * 60 * 24 * 5);  设置cookie的有效期为 5 天 
			response.addCookie(cookieSessionID);*/

			return "success";
		}
		return "false";
	}
}
