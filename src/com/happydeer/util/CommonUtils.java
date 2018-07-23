package com.happydeer.util;

/**
 *
 *作者：HCK
 *创建日期：2018年6月28日
 */
public class CommonUtils {
	
	public static void printList(Comparable[] arr) {
		System.out.print("{");
		for (Comparable a : arr) {
			System.out.println(a.toString());
		}
		System.out.println("}");
		
	}
	public static void printList(int[] arr) {
		System.out.print("arr：{");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println("}");
	}
}
