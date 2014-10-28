
/**
 * @author verphen
 * @date 2014年10月9日  上午12:34:13
 */

package com.verphen.test1;

import com.verphen.test.IOne;
import com.verphen.test.ITwo;

public class ImpleClassTest implements IOne,ITwo{

	public boolean del() {
		return false;
	}

	public boolean update() {
		return false;
	}

	public boolean add() {
		return false;
	}
	
	public static void main(String[] args) {
		
		double b = Math.random() * 100;
		System.out.println(b);
		System.out.println(Math.floor(b));
		long i = Math.round(b);
		System.out.println(i);
		
		
	}

}


