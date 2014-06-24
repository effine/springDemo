package com.verphen.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.verphen.dao.impl.TestJdbcDaoImpl;
import com.verphen.model.Student;
import com.verphen.model.User;
import com.verphen.utils.ImgUtils;

@Controller
@RequestMapping("/home")
public class HomeController {

	/** 组件日志 */
	private static final Logger logger = Logger.getLogger(HomeController.class);

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

			System.out
					.println("-------------------1111111111111111111111----------------------");
			logger.info("测试日志-----------------");
			logger.debug("--------测试日志----------------");

			logger.info("Here is some INFO");

			logger.warn("Here is some WARN");

			logger.error("Here is some ERROR");

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
			HttpServletResponse response, HttpSession session, int x, int y,
			int width, int height) {

		/*
		 * int x = sub(px); int y = sub(py); int width = sub(pwidth); int height
		 * = sub(pheight);
		 */

		String path = request.getServletContext().getRealPath("/")
				+ "resources/upload/";
		String filename = session.getAttribute("filename").toString();

		String srcpath = path + filename;
		String subpath = path + "Cut" + filename;
		try {
			ImgUtils.mycut(srcpath, subpath, x, y, width, height);
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

	/********************** 测试controller *****************************/
	@RequestMapping("t1")
	@ResponseBody
	public String t1(HttpServletRequest request, HttpServletResponse response,
			User user) {
		System.out.println("----------------------" + user.getName() + ": "
				+ user.getPasswd());
		return user.getName() + ": " + user.getPasswd();
	}

	public static void main(String[] args) {
		List<Student> list = new TestJdbcDaoImpl().getStuList();
		System.out.println("测试数据库是否连接：" + list.size());
	}

}
