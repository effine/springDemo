/**
 * @author verphen
 * @date 2014年9月29日  上午12:31:52
 */

package com.verphen.test;

public class ConstructorTest {

	private String name;

	public ConstructorTest(String name) {
		this.name = name;
	}

	public ConstructorTest() {
		this("verphen");
	}

	public void test() {

	}

	public static void main(String[] args) {
		System.err.println("-------------");
	}

}
