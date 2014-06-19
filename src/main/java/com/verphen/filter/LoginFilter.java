/**
 * @author verphen
 * @date 2014年6月19日  上午11:16:50
 */

package com.verphen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("==============过滤器: init================");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("==============过滤器: doFilter================");

		chain.doFilter(request, response);
	}

	public void destroy() {

		System.out.println("==============过滤器: destroy================");
	}

}
