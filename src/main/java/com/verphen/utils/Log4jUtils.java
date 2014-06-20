/**
 * @author verphen
 * @date 2014年6月20日  上午10:20:42
 */

package com.verphen.utils;

import org.apache.log4j.Logger;

public class Log4jUtils {

	private static Logger logger = Logger.getLogger(Log4jUtils.class);

	public static void main(String[] args) {

		// 记录debug级别的信息
		logger.debug("This is debug message.");

		// 记录info级别的信息
		logger.info("This is info message.");

		// 记录error级别的信息
		logger.error("This is error message.");
	}
}
