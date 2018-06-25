package com.happydeer.problems.easy;

/**
 * 
 *搜索插入位置：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引
 *如果目标值不存在于数组中，返回它将会被按顺序插入的位置。假设数组中无重复元素
 *作者：HCK
 *创建日期：2018年6月25日
 */
public class SearchInsert {
	
	public static int mySolution(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		
		for (int i = 0; i < len; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		
		if (target > nums[len-1]) {
			return len;
		}
		return 0;//无用返回，只为语义正确
	}
	
	/**
	 * 一个字，漂亮
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int greatSolution(int[] nums, int target) {
		int i;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				break;
			}
		}
		return i;
	}
	
	/**
	 * 数组长度较大是可以如此优化
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int otherSolution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int middle = (left + right) / 2;
            int cmp = nums[middle] - target;
            if (cmp < 0) {
                left = middle + 1;
            } else if (cmp > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        if (nums[left] > target) {
            return left;
        } else if (nums[right] < target){
            return right + 1;
        } else if (nums[left] == target) {
            return left;
        } else {
            return right;
        }
	}
	
}
