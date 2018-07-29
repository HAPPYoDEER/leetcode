package com.happydeer.problems.easy;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 作者：HCK 创建日期：2018年7月29日
 */
public class LetterCombination {

	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		System.out.println(b);
		List<String> list = new LetterCombination().copySolution("23");
		System.out.println(System.currentTimeMillis() - b);
		System.out.println(list);
		
		LinkedList<String> link = new LinkedList<>();
		link.add("sdfas");
		System.out.println(link.peek());
		System.out.println(link.removeFirst());
		System.out.println(link);
		System.out.println(link.remove());
		System.out.println(link);
	}

	public List<String> copySolution(String digits) {
		int len = digits.length();
		LinkedList<String> result = new LinkedList<>();
		if (0 == len) {
			return result;
		}
		String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for (int i = 0; i < len; i++) {
			String currArr = mapping[Integer.parseInt(digits.charAt(i) + "")];
			while (result.peek().length() == i) {
				String temp = result.remove();
				for (char s : currArr.toCharArray()) {
					result.add(temp + s);
				}
			}
		}
		return result;
	}
	
	/**
	 * low
	 * @param x
	 * @return
	 */
	private String praseDigit(char x) {
		String result;
		switch (x) {
		case '2':
			result = "abc";
			break;
		case '3':
			result = "def";
			break;
		case '4':
			result = "ghi";
			break;
		case '5':
			result = "jkl";
			break;
		case '6':
			result = "mno";
			break;
		case '7':
			result = "pors";
			break;
		case '8':
			result = "tuv";
			break;
		case '9':
			result = "wxyz";
			break;
		default:
			result = "";
		}
		return result;
	}
}
