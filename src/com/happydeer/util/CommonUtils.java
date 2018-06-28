package com.happydeer.util;

/**
 *
 *作者：HCK
 *创建日期：2018年6月28日
 */
public class CommonUtils {
	public static void printList(Comparable[] arr) {
		for (Comparable a : arr) {
			System.out.println(a.toString());
		}
	}
	public static void printList(int[] arr) {
		System.out.println("{");
		for (Comparable i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println("}");
	}
}
