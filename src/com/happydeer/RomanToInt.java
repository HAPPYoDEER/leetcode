package com.happydeer;

/**
 *
 *作者：HCK
 *创建日期：2018年4月1日
 */
public class RomanToInt {
	
	
	public int solution1(String s) {
		char[] carr = s.toCharArray();
		int result = 0;
		for (int i = 0; i < carr.length; i++) {
			int val = getRomanVal(carr[i]);
			if (i == carr.length-1 || val >= getRomanVal(carr[i+1])) {
				result += val;
			} else {
				result -= val;
			}
			
		}
		return result;
	}
	
	public int solution2(String s) {
		char[] carr = s.toCharArray();
		int pre = getRomanVal(carr[0]);
		int result = 0;
		int now = 0;
		for (int i = 1; i < carr.length; i++) {
			now = getRomanVal(carr[i]);
			
			if (pre >= now) {
				result += now;
			} else {
				result = result + now - 2 * pre;
			}
			pre = now;
		}
		return result;
	}
	private int getRomanVal(char c) {
		if (c == 'M') return 1000;
		if (c == 'D') return 500;
		if (c == 'C') return 100;
		if (c == 'L') return 50;
		if (c == 'X') return 10;
		if (c == 'V') return 5;
		return 1;
	}
}
