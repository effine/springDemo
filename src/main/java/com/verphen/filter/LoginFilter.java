/**
 * @author verphen
 * @date 2014年6月12日  下午3:57:09
 */

package com.verphen.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		boolean flag = false;

		Cookie[] cookie = request.getCookies();
		for (Cookie c : cookie) {
			if ("username".equalsIgnoreCase(c.getName())
					&& "test".equalsIgnoreCase(c.getValue())) {
				flag = true;
				break;
			}
		}

		if (flag) {
			response.sendRedirect("/springDemo/success.jsp");
		} else {
			// response.sendRedirect("/springDemo/login.jsp");
			filterChain.doFilter(request, response);
		}
	}
}
