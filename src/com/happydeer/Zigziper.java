package com.happydeer;

public class Zigziper {
	public static String convert(String s,int numRows) {
		int len = s.length();
		if(len == 0) return "";
		else {
			if(numRows==0 || numRows==1 || numRows>=len) {
				return s;
			}else {
				StringBuilder sb = new StringBuilder();
				for(int i=1;i<=numRows;i++) {
					int dx = (numRows-1)*2,
						count = 1,
						index = i-1;
					sb.append(s.charAt(index));
					if(i==1 || i==numRows) {
						while((i+dx*count)<=len) {
							index = i+dx*count;
							sb.append(s.charAt(index-1));
							count++;
						}
					}else {
						int x = dx-(i-1)*2,
						    y = (i-1)*2;
						index = i;
						while((index+=count*(count%2==0?y:x))<=len) {
							System.out.println(count+"--"+i+"--"+(index)+"--"+s.charAt(index-1));
							sb.append(s.charAt(index-1));
							count ++;
						}
					}
				}
				return sb.toString();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(convert("abcdef",4));
	}
}
