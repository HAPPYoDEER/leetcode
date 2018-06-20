package com.happydeer.problems;

import java.util.logging.LoggingMXBean;

public class LongestPalindrome {
	/**
	 * 这里发生过一个悲伤的故事
	 * 
	 * 恶心点：奇偶子串，特殊处理->解决办法:插桩法
	 * 
	 * 超时问题：不能通过
	 *
	 * @param 字符串
	 * @return 字符串中的最长回文子串
	 */
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		else {
			String max = "";
			for (int i = 0; i < len; i++) {
				String curr = "";
				int prev = i - 1, next = i + 1;
				if (prev == -1) {
					while (next < len && s.charAt(next) == s.charAt(next - 1)) {
						curr = s.substring(i, next + 1);
						next++;
					}
					if (curr.length() > len / 2) {
						max = curr;
						break;
					}
				} else if (next == len) {

				} else {
					curr = getLonger(getEven(s, i), getOdd(s, i));
				}
				max = getLonger(curr, max);
			}
			return max;
		}
	}

	/**
	 * 关于超时改进的递归算法 ...递归到没边 所以还是迭代 改进思想，从中间开始读
	 * 运行时间:103ms
	 * @param args
	 */
	public static String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		else {
			int mid, prev, next;
			prev = len / 2 - 1;
			next = len / 2;
			String max = "";
			if (len % 2 == 1) {
				mid = (len - 1) / 2;
				max = getLonger(getOdd(s, mid), getEven(s, mid));
			} else {
				prev = len / 2 - 1;
				max = getLonger(getOdd(s, prev), getEven(s, prev));
			}
			String prevStr = "", nextStr = "";
			for (; prev >= 0; prev--) {
				prevStr = getLonger(getLonger(getEven(s, prev), getOdd(s, prev)), prevStr);
				if (prev>5&&prevStr.length() > ((prev) * 2))
					break;
			}
			for (; next < len - 1; next++) {
				nextStr = getLonger(getLonger(getEven(s, next), getOdd(s, next)), nextStr);
				if ((len - next)>5&&nextStr.length() > ((len - next + 1) * 2))
					break;
			}
			return getLonger(getLonger(prevStr, nextStr), max);

		}
	}

	private static String getEven(String str, int index) {
		String newStr = str.substring(index, index + 1);
		int prev = index - 1, next = index + 1, len = str.length();
		if (str.charAt(index + 1) == str.charAt(index)) {
			next++;
			newStr = str.substring(index, next);
			while (prev >= 0 && next < len) {
				if (str.charAt(prev) != str.charAt(next)) {
					break;
				}
				if (str.charAt(prev) == str.charAt(next)) {
					newStr = str.substring(prev, next + 1);
					prev--;
					next++;
				}

			}
		}

		return newStr;
	}

	private static String getOdd(String str, int index) {
		String newStr = str.substring(index, index + 1);
		int prev = index - 1, next = index + 1, len = str.length();
		while (prev >= 0 && next < len) {
			if (str.charAt(prev) != str.charAt(next)) {
				break;
			}
			if (str.charAt(prev) == str.charAt(next)) {
				newStr = str.substring(prev, next + 1);
				prev--;
				next++;
			}

		}
		return newStr;
	}

	private static String getLonger(String s1, String s2) {
		if (s1.length() >= s2.length())
			return s1;
		else
			return s2;
	}

	
	/**
	 * sample 8 ms submission
	 * 大神作品，无法直视
	 * @param args
	 */
    int len = 0, maxLength = 0, init = 0;
    public String longestPalindrome3(String s) {
        char[] chars = s.toCharArray();
        len = s.length();
        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    public int manacher(char[] chars, int k) {
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        return nextCenter;
    }
	public static void main(String[] args) {
		
	}
}
