package com.happydeer.problems.easy;

/**
 *
 *作者：HCK
 *创建日期：2018年9月11日
 */
public class LengthOfLastWord {
	public static void main(String[] args) {
//		String s = "   2   4 ad";
		String s = ";;;;fsd;;;dfs;;";
		for (String str:s.split(";")) {
			System.out.println(str);
		}
		System.out.println(solution("hello world"));
	}
	/**
	 * 分割单词数组，返回最后一个单词的长度
	 * @param s
	 * @return
	 */
	public static int solution(String s) {
		String[] strArr = s.trim().split(" ");
		return strArr[strArr.length - 1].length();
	}
	
	/**
	 * 大佬
	 * @param s
	 * @return
	 */
	private static int greatSolution(String s) {
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
}
