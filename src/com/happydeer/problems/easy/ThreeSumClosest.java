package com.happydeer.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.happydeer.util.ClassicMath;

/**
 *
 * 作者：HCK 创建日期：2018年6月27日
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { -4, -7, -2, 2, 5, -2, 1, 9, 3, 9, 4, 9, -9, -3, 7, 4, 1, 0, 8, 5, -7, -7 };

		// int x = ThreeSumClosest.mySolution(nums, 29);
		System.out.println("阶乘:" + ThreeSumClosest.factorial(21));
		System.out.println("阶乘:" + ThreeSumClosest.factorial(20));
		System.out.println("阶乘:" + ThreeSumClosest.factorial(13));
		System.out.println("阶乘:" + ThreeSumClosest.factorial(12));
		System.out.println("整型:" + Integer.MAX_VALUE);
		System.out.println("long:" + Long.MAX_VALUE);
		System.out.println(" " + ClassicMath.combination(16, 3));
	}

	public static int mySolution(int[] nums, int target) {
		int len = nums.length;

		System.out.println(len + "==" + combination(22, 4));
		int[] set = new int[10000];
		int index = 0;
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					set[index++] = nums[i] + nums[j] + nums[k];
				}
			}
		}
		Arrays.sort(set);
		for (int i = 0; i < set.length; i++) {
			if (target == set[i])
				break;
			if (target > set[i] & i < set.length - 1 && target < set[i + 1]) {
				return set[i + 1] - 1 > target - set[i] ? set[i] : set[i + 1];
			}
			if (target > set[i] & i == set.length - 1) {
				return set[i];
			}
		}
		return target;

	}

	public static long factorial(int n) {
		return n > 1 ? n * factorial(n - 1) : 1;
	}

	public static long combination(int n, int m) {
		return n < m ? 0 : n == m ? 1 : factorial(n) / factorial(n - m) / factorial(m);
	}
}
