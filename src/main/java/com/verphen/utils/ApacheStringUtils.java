/**
 * @author verphen
 * @date 2014年6月18日  下午11:51:11
 */

package com.verphen.utils;

import org.apache.commons.lang3.StringUtils;

public class ApacheStringUtils {
	public static void main(String[] args) {
		String test = null;
		boolean b = StringUtils.isNotEmpty(test);
		System.out.println(b);
		System.out.println(StringUtils.isBlank(""));
	}
}
