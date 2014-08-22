/**
 * @author verphen
 * @date 2014年8月5日  下午10:20:52
 */

package com.verphen.test;

public class TestEfficiency {
	public static void main(String[] args) {

		String str = "12";

		int i = Integer.parseInt(str,10);
		int i2 = Integer.parseInt(str);
		int i1 = Integer.parseInt(str,2);
		System.out.println(i);
		System.out.println(i1);

		int j = Integer.valueOf(str).intValue();
		int j2 = Integer.valueOf(str,10);
		
		

	}

}
