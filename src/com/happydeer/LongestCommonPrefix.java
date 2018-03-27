package com.happydeer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 字符串数组最长公共前缀
 * 
 * @author 0o0
 *
 */
public class LongestCommonPrefix {

	/**
	 * 巨恶心的解体方案（ps：自己写的真是坨屎）
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		
		for(String s:strs) {
			if("".equals(s)) {
				System.out.println("kong");
				return "";
			}
		}
		List<String> lessList = Arrays.asList(strs);
		String minLength = Collections.min(lessList, new Comparator<String>() {
			public int compare(String s1, String s2) {
				Integer x = s1.length(), y = s2.length();
				return x.compareTo(y);
			}
		});
		System.out.println(minLength.length());
		String commonPrefix = "";
		boolean xflag = false;
		for(int i=1,n=minLength.length();i<=n;i++) {
			String sub = minLength.substring(0, i);
			boolean flag = false;
			for(int j=0;j<strs.length;j++) {
				if(!sub.equals(strs[j].substring(0, i))) {
					flag = true;
					xflag = true;
					break;
				}
			}
			if(flag) {
				commonPrefix = minLength.substring(0,i-1);
				break;
			}
		}
		if(!xflag) {
			return  minLength;
		}
		return commonPrefix;
	}
	
	/**
	 * 完美8ms简洁解体方案
	 * @param args
	 */
	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if(strs == null || strs.length == 0)    return "";
	        String pre = strs[0];
	        int i = 1;
	        while(i < strs.length){
	            while(strs[i].indexOf(pre) != 0)
	                pre = pre.substring(0,pre.length()-1);
	            i++;
	        }
	        return pre;
	    }
	}
	public static void main(String[] args) {
		String[] strs = { "abcdef", "abcd", "abc" };

		System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
	}

}
