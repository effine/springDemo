/**
 * @author verphen
 * @date 2014年9月5日  上午12:07:52
 */

package com.verphen.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class FastjsonTest {

	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("11", 11);
		JSON.toJSONString(map);
		
	}

}
