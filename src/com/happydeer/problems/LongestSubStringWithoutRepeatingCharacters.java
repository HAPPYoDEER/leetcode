package com.happydeer.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
	/*
	 * Question Description:
	 * 问题描述：
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 对给定一个字符串，找出无重复字符的最长子串的长度
	 * Examples:
	 * 去几个例子：
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 对给定的字符串"abcabcbb",答案是"abc"，长度为3
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * 
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note
	 * 
	 * that the answer must be a substring, "pwke" is a subsequence and not a
	 * 
	 * substring.
	 */

	public static int lengthOfLongestSubstring(String s) {
		Set<String> mightSet = new HashSet<>();
		int index=0;
		for(int i=0,n=s.length();i<n;i++) {
			boolean flag = false;
			String s2 = s.substring(0,i);
			char curr = s.charAt(i);
			for(int j=0,m=s2.length();j<m;j++) {
				if(curr == s2.charAt(j)) {
					index = j;
					flag = true;
					break;
				}
			}
			if(!flag) {
				String s1 = s.substring(index, i+1);
				mightSet.add(s1);
			}
		}
		if(mightSet.size()==0) {
			return 0;
		}
		String result = Collections.max(mightSet, new Comparator<String>() {
				public int compare(String s1,String s2) {
					Integer x = s1.length(),
							y = s2.length();
					return x.compareTo(y);
			}
		});
		return result.length();
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
