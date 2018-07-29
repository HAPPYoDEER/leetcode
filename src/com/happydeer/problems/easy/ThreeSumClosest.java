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
		// int[] nums = { -1, 0, 1, 2, -1, -4 };
		// int[] nums = { 1, 4, 5, 6, 7, 8};
//		int[] nums = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
//		int[] nums = {1,1,1,0};
		int[] nums = {25,-12,2,66,-8,67,67,-93,-97,-68,-49,-24,49,90,31,87,-1,14,50,-25,69,-91,-23,82,-43,96,80,43,4,-87,40,24,-71,-10,-16,78,-60,-20,-84,69,84,84,16,-23,-25,88,15,72,-82,-72,-16,49,50,26,3,26,-92,82,-69,60,-81,24,-25,-47,-77,-37,-33,69,21,-50,56,-43,18,-87,96,47,59,37,100,23,-34,-69,-12,-83,-65,91,75,100,24,80,64,-27,-31,39,-46,-73,88,-13,-10,67,95,27,91,-61,-44,67,0,-29,-57,-61,-62,83,-6,82,-58,-58,-5,-87,-44,9,-20,-28,3,17,57,-63,78,34,7,-68,30,-49,77,-97,15,-42,-49,-22,-60,78,84,35,19};
		System.out.println(copySolution(nums, 250));
	}

	
	
	
	public static int beautySolution(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                	return sum;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
	}
	
	public static int copySolution(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int closestSum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int tempSum = nums[i] + nums[left] + nums[right];
				int tempDiff = Math.abs(tempSum - target); 
				if (tempDiff < diff) {
					closestSum = tempSum;
					diff = tempDiff;
				}
				
				if (tempSum < target) {
					left++;
					
				} else if (tempSum > target) {
					right--;
					
				} else {
					return tempSum;
				}
			}
		}
		return closestSum;
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
		// 三个循环嵌套太耗时
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

}
