package com.happydeer.problems.easy;

/**
 *
 *作者：HCK
 *创建日期：2018年6月25日
 */
public class StrStr {
	/**
	 * 判断第二个字符串中第一字符串首先出现的位置。注：leetcode测试用例貌似不要求判断非空？
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int mySolution(String haystack, String needle) {
		if (haystack != null & needle != null) {
			if ("".equals(needle)) {
				return 0;
			}
			return haystack.indexOf(needle);
			/*
			if (haystack.length() < needle.length()) {
				return -1;
			}
			int len = needle.length(), res = -1;
			boolean find = false;
			for (int i = 0; i < haystack.length() - len; i++) {
				if (needle.equals(haystack.substring(i, i + len))) {
					find = true;
					res = i;
					break;
				}
			}
			return find ? res : -1;
*/		}
		return -1;
	}
	
	/**
	 * 有点投机取巧的嫌疑呢
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int commonSolution(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
	
	public static void main(String[] args) {
		System.out.println("hello".substring(3, 5));
	}
}
