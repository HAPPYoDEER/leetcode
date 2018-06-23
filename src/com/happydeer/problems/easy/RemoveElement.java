package com.happydeer.problems.easy;

/**
 *
 *作者：HCK
 *创建日期：2018年6月23日
 */
public class RemoveElement {
	
	public static void main(String[] args) {
		int[] nums = {2,3,3,2};
		System.out.println(mySolution(nums, 2));
	}
	/**
	 * 
	 * @param nums 要操作 的数组
	 * @param val 要删除的值
	 * @return 删除指定的值数组剩余的元素个数
	 */
	public static int mySolution(int[] nums, int val) {
        int x = 0, y = 0, len = nums.length;
		int[] copy = new int[len];
		
		for (int i = 0; i < len; i++) {
			if ( nums[i] == val) {
				x++;
				copy[len-x] = nums[i];
			} else {
				copy[y] = nums[i];
				y++;
			}
		}
		for (int i =0; i < y; i++) {
			nums[i] = copy[i];
		}
		print(nums);
		return y;
	}
	
	
	public static int bestSolution(int[]nums, int val) {
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]!= val) {
				nums[res++] = nums[i];
			}
		}
		return res;
	}
	
	private static void print(int[] nums) {
		for(int i:nums) {
			System.out.print(i+ " ");
		}
		System.out.println("end");
	}
}
