
/**
 * @author verphen
 * @date 2014年10月9日  上午12:31:35
 */

package com.verphen.test;

public class ImpleClassTest implements IOne,ITwo{
	

	public boolean del() {
		System.out.println(IOne.i);
		return false;
	}

	public boolean add() {
		return false;
	}

	public boolean update() {
		return false;
	}
}


