package com.happydeer.problems;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		/**
		 * 方法一：
		 *    将整数转换成字符串，进行判断
		 */
		String s = x + "";
		int start = 0;
		if(x<0){
            start = 1;
        }
		int end = s.length()-1;
		while(start<end) {
			if(s.charAt(start)==s.charAt(end)) {
				start++;
				end--;
			}else {
				return false;
			}
		}
		return true;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(-2147447412));
	}
}
