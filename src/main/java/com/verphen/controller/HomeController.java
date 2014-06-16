package com.verphen.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/isAutologin")
	public @ResponseBody
	String isAutologin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

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
				if ("username".equals(c.getName())) {
					username = c.getValue();
				}

				if ("password".equals(c.getName())) {
					password = c.getValue();
				}
			}
			String result = login(username, password, "true", request, response);
			if ("pageSuccess".equals(result)) {
				return "true";
			} else if ("pageFalse".equals(result)) {
				return "false";
			}
		}
		return "false";
	}

	@RequestMapping("/login")
	public @ResponseBody
	String login(String username, String password, String isAutologin,
			HttpServletRequest request, HttpServletResponse response) {

		if ("test".equalsIgnoreCase(username)
				&& "test".equalsIgnoreCase(password)) {

			if ("true".equals(isAutologin)) {
				Cookie autologin = new Cookie("isAutologin", isAutologin);
				autologin.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
				response.addCookie(autologin);

				Cookie cookieUsername = new Cookie("username", username);
				cookieUsername.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
				response.addCookie(cookieUsername);

				Cookie cookiePassword = new Cookie("password", password);
				cookieUsername.setMaxAge(60 * 60 * 24 * 5); /* 设置cookie的有效期为 5 天 */
				response.addCookie(cookiePassword);
			}
			return "pageSuccess";
		}
		return "pageFalse";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {

		Cookie[] cookie = request.getCookies();

		for (Cookie c : cookie) {
			if ("username".equals(c.getName())
					|| "password".equals(c.getName())) {
				c.setValue(null);
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return "login";
	}

	@RequestMapping("/upload")
	public @ResponseBody
	String upload(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "selfile", required = true) MultipartFile selfile) {

		String uploadPath = "D:\\upload\\";

		String filename = selfile.getOriginalFilename();
		filename = Long.toString(System.currentTimeMillis())+filename.substring(filename.lastIndexOf("."));
		File targetFile = new File(uploadPath, filename);

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		try {
			selfile.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadPath + filename;
	}
}
