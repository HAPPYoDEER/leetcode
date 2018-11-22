package com.happydeer.problems.easy;

import java.util.Arrays;

/**
 *
 *作者：HCK
 *创建日期：2018年11月20日
 */
public class MergeSortedArray {
	
	/**
	 * this is 2:00 am,i wanna to sleep
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		for (int i = m, j = 0; i < nums1.length; i++,j++) {
			nums1[i] = nums2[j];
		}
		Arrays.sort(nums1);
	}
	
	/**
	 * awesome
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void greatSolution(int[] nums1, int m, int[] nums2, int n) {
		int p = m-- + n-- -1;
		while (m >= 0 && n >= 0) {
			nums1[p--] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
		}
		while (n >= 0) {
			nums1[p--] = nums2[n--];
		}
	}
}
