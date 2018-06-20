package com.happydeer.util;

/**
 *
 *作者：HCK
 *创建日期：2018年6月20日
 */
public class Swap {
//	public static void swap(Comparable<? extends Number> c1, Comparable<? extends Number> c2) {
//		Comparable<? extends Number> temp;
//		temp = c1;
//		c1 = c2;
//		c2 = temp;
//	}
	public static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}
	public static void main(String[] args) {
		int a = 3;
		int b= 4;
		swap(a,b);
		System.out.println(a + " " + b);
	}
}
