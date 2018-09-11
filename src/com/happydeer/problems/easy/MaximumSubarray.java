package com.happydeer.problems.easy;

/**
 *
 * 作者：HCK 创建日期：2018年9月11日
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solution(nums));
	}

	/**
	 * 分治法
	 * @param nums 整型数组
	 * @return 连续子数组的最大和
	 */
	public static int solution(int[] nums) {
		return maximumSubarray(nums, 0, nums.length - 1);
	}

	private static int maximumSubarray(int[] nums,int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = start + ((end - start) / 2);
		int maxLeft = maximumSubarray(nums, start, mid);
		int maxRight = maximumSubarray(nums, mid + 1, end);
		int max = maxLeft > maxRight ? maxLeft : maxRight;
		int maxMid = 0;
		int temp = 0, maxMidL = 0, maxMidR = 0;

		for (int i = mid + 1; i <= end; i++) {
			temp += nums[i];
			if (temp > maxMidR) {
				maxMidR = temp;
			}
		}
		temp = 0;
		for (int i = mid - 1; i >= start; i--) {
			temp += nums[i];
			if (temp > maxMidL) {
				maxMidL = temp;
			}
		}
		maxMid = maxMidL + maxMidR + nums[mid];
		max = max < maxMid ? maxMid : max;
		return max;

	}
	
	/**
	 * 大佬的世界我不懂
	 * @param nums
	 * @return
	 */
	public static int greatSolution(int[] nums) {
		int sum = 0;
		int sumMax = nums[0];
		for (int i : nums) {
			sum += i;
			sumMax = Math.max(sumMax, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return sumMax;
	}
}
