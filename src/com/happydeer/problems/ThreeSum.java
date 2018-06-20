package com.happydeer.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 作者：HCK 创建日期：2018年4月14日
 */
public class ThreeSum {
	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		int minValue = Integer.MIN_VALUE;
		int maxValue = Integer.MAX_VALUE;
		int negSize = 0;
		int posSize = 0;
		int zeroSize = 0;
		for (int val : nums) {
			if(val<minValue) {
				minValue = val;
			}
			if(val > maxValue) {
				maxValue = val;
			}
			if(val < 0) {
				negSize++;
			}
			else if(val > 0) {
				posSize++;
			}else {
				zeroSize++;
			}
		}
		if (zeroSize > 3) {
			result.add(Arrays.asList(0,0,0));
		}
		if (negSize == 0 || posSize == 0) {
			return result;
		}
		if (minValue * 2 + maxValue > 0) {
			maxValue = -minValue * 2;
		}else if(maxValue * 2 + minValue < 0){
			minValue = -maxValue * 2;
		}
		int[] map = new int[maxValue-minValue + 1];
		int[] negs = new int[negSize];
		int[] poses = new int[posSize];
		negSize = 0;
		posSize = 0;
		for(int val : nums) {
			if(val >= minValue && val <= maxValue) {
				if(map[val-minValue]++ == 0) {
					if(val > 0) {
						poses[posSize++] = val;
					}else if (val < 0) {
						negs[negSize++] = val;
					}
				}
			}
		}
		
		Arrays.sort(poses, 0, posSize);
		Arrays.sort(negs, 0, negSize);
		int basej = 0;
		for(int i = negSize-1;i>=0;i--) {
			int negVal = negs[i];
			int minp = (-negVal) >>> 1;
			while (basej < posSize && poses[basej] < minp) {
				basej++;
			}
			for(int j= basej;j < posSize;j++) {
				int posVal = poses[j];
				int cenVal = 0 - negVal - posVal;
				if(cenVal >= negVal && cenVal <= posVal) {
					if(cenVal ==negVal) {
						if(map[negVal-minValue]>1) {
							result.add(Arrays.asList(negVal,negVal,posVal));
						}
					} else if (cenVal == posVal) {
						if(map[posVal - minValue] >1) {
							result.add(Arrays.asList(negVal,posVal,posVal));
						}
					} else {
						if (map[cenVal - minValue]>0) {
							result.add(Arrays.asList(negVal,cenVal,posVal));
						}
					}
					
				} else if(cenVal < negVal) {
					break;
				}
			}
		}
		return result;
		
	}
}

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (len < 3) {
			return result;
		}

		Arrays.sort(nums);

		// for all number that can be the 1st number of triplet
		for (int i = 0; i < len - 1; i++) {
			int firstNumber = nums[i];

			// skip all duplicated first number
			if (i == 0 || firstNumber != nums[i - 1]) {

				int leftIndex = i + 1;
				int rightIndex = len - 1;
				int twoSumTarget = 0 - firstNumber;

				// try to find two numbers that sum up to twoSumTarget
				while (leftIndex < rightIndex) {
					int twoSum = nums[leftIndex] + nums[rightIndex];
					if (twoSum == twoSumTarget) {
						// one valid triplet found!!
						result.add(Arrays.asList(firstNumber, nums[leftIndex], nums[rightIndex]));
						// skip duplicated nums[leftIndex]
						while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
							leftIndex++;
						}
						// skip duplicated nums[rightIndex]
						while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
							rightIndex--;
						}
						// move to next non-duplicates
						leftIndex++;
						rightIndex--;
					} else if (twoSum < twoSumTarget) {
						// move left towards right to
						// make twoSum larger to get closer to twoSumTarget
						leftIndex++;
					} else {
						rightIndex--;
					}
				}

			}
		}

		return result;
	}
}