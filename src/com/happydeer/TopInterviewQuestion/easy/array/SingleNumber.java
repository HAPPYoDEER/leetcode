package com.happydeer.TopInterviewQuestion.easy.array;

import java.util.Arrays;

/**
 *
 *作者：HCK
 *创建日期：2018年5月11日
 */
public class SingleNumber {
	public static int solution(int[] nums) {
		int len = nums.length ,i ,result = 0;
		for (i = 0; i < len; i++) {
			result ^= nums[i]; 
		}
		return result;
	}

	public static int solution2(int[] nums) {
		Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        throw new IllegalAccessError("no single number");
	}
	public static void main(String[] args) {
		int[] a = {4,1,2,1,2};
		System.out.println(13^ 18);
	}
}
