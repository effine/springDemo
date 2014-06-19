package com.verphen.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.verphen.utils.ImgUtils;

@Controller
@RequestMapping("/home")
public class HomeController {

	/** 组件日志 */
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class.getName());

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

				logger.info("测试日志-----------------");

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
	public String upload(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			@RequestParam(value = "selfile", required = true) MultipartFile selfile) {

		String uploadPath = request.getServletContext().getRealPath("/")
				+ "resources\\upload\\";

		String filename = selfile.getOriginalFilename();
		filename = Long.toString(System.currentTimeMillis())
				+ filename.substring(filename.lastIndexOf("."));
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
		session.setAttribute("filename", filename);
		return "index";
	}

	@RequestMapping("/cutImg")
	public String cutImg(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, String px,
			String py, String pwidth, String pheight) {

		int x = sub(px);
		int y = sub(py);
		int width = sub(pwidth);
		int height = sub(pheight);

		String path = request.getServletContext().getRealPath("/")
				+ "resources/upload/";
		String filename = session.getAttribute("filename").toString();

		String srcpath = path + filename;
		String subpath = path + "Cut" + filename;
		try {
			ImgUtils.cut(srcpath, subpath, x, y, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

	public int sub(String s) {
		if (s.contains(".")) {
			s = s.substring(0, s.lastIndexOf("."));
		}
		return Integer.parseInt(s);
	}

	@RequestMapping("test")
	public String test() {
		System.out.println("-------跳转至WEB-INF目录下页面------");
		return "test";
	}

}
