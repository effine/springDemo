/**
 * @author verphen
 * @date 2014年6月19日  上午10:30:25
 */

package com.verphen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public LoginInterceptor() {
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		System.out.println("==============执行顺序: 1、preHandle================");

		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("==============执行顺序: 2、postHandle================");
		/* 返回到主页 */
		// response.sendRedirect("/index.jsp");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out
				.println("==============执行顺序: 3、afterCompletion================");
	}

}
