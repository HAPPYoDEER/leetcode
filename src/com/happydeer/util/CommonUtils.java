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
			System.out.print(a.toString() + ",");
		}
		System.out.println("}");
		
	}
	public static void printList(int[] arr) {
		System.out.print("arr：{");
		int i = 0;
		while (i < arr.length - 1) {
			System.out.print(arr[i] + ",");
			i++;
		}
		System.out.println(arr[arr.length - 1] + "}");
	}
}
