package com.happydeer.problems.easy;

import java.util.Arrays;

import com.happydeer.util.CommonUtils;

/**
 *
 * 作者：HCK 创建日期：2018年6月28日
 */
public class SingleNumberII {
	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };
		Arrays.sort(nums);
		CommonUtils.printList(nums);
		System.out.println(SingleNumberII.mySolution(nums));

	}

	public static int mySolution(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < len; i++) {
			if (i > 0 & i < len - 1) {
				if (nums[i] != nums[i - 1] & nums[i] != nums[i + 1]) {
					res = nums[i];
				}
			} else {
				if (i == 0 && nums[i] != nums[i + 1]) {
					res = nums[i];
				}
				if (i == (len - 1) && nums[i] != nums[i - 1]) {
					res = nums[i];
				}
			}
		}
		return res;
	}
	/**
	 * 大神果然是大神，完全看不懂
	 * @param nums
	 * @return
	 */
	public static int greatSolution(int[] nums) {
		int ones = 0, twos = 0;
		for (int i = 0; i < nums.length; i++) {
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
	}
}
