package com.happydeer.problems.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.happydeer.util.CommonUtils;

/**
 *
 * 作者：HCK 创建日期：2018年6月27日
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// int[] nums = { -4, -7, -2, 2, 5, -2, 1, 9, 3, 9, 4, 9, -9, -3, 7, 4, 1, 0, 8,
		// 5, -7, -7 };
//		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { 1, 4, 5, 6, 7, 8};
		System.out.println(badSolution2(nums, 0));
	}

	/**
	 * 
	 */
	public static int badSolution2(int[] nums, int target) {
		int len = nums.length;
		Set<Integer> hs = new TreeSet<>();
		Arrays.sort(nums);
		CommonUtils.printList(nums);
		for (int k = 2, a = nums[0], b = nums[1]; k < len; k++) {
			hs.add(a + b + nums[k]);
		}
		for (int k = 1, a = nums[0], c = nums[len - 1]; k < len - 1; k++) {
			hs.add(a + c + nums[k]);
		}
		for (int k = 0, b = nums[len - 2], c = nums[len - 1]; k < len - 2; k++) {
			hs.add(b + c + nums[k]);
		}
		for (int i = 2; i < len -3; i++) {
			hs.add(nums[i] + nums[i + 1] + nums[i + 2]);
		}
		int prev = 0, index = 0;
		System.out.println(hs.toString());
		for (Integer i : hs) {
			int in = i.intValue();
			if (target == in)
				return target;
			if (target < in) {
				if (index == 0) {
					return in;
				} else {
					return (target - prev) > (in - target) ? in : prev;
				}
			}
			prev = in;
			index++;
		}
		return prev;
	}

	/**
	 * 自认逻辑没问题。但是时间超限，未通过leetocde全部测试用例
	 * 
	 * @param nums
	 *            原始数组
	 * @param target
	 *            目标值
	 * @return 结果
	 */
	public static int mySolution(int[] nums, int target) {
		int len = nums.length;
		Set<Integer> hs = new TreeSet<>();
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					int tmp = nums[i] + nums[j] + nums[k];
					hs.add(Integer.valueOf(tmp));
				}
			}
		}
		int index = 0, prev = 0;
		for (Integer i : hs) {
			int in = i.intValue();
			if (target == in)
				return target;
			if (target < in & index > 0) {
				if (index == 0) {
					return in;
				} else {
					return (target - prev) > (in - target) ? in : prev;
				}
			}
			prev = in;
			index++;
		}
		return prev;
	}

	public static long factorial(int n) {
		return n > 1 ? n * factorial(n - 1) : 1;
	}

	public static long combination(int n, int m) {
		return n < m ? 0 : n == m ? 1 : factorial(n) / factorial(n - m) / factorial(m);
	}
}
