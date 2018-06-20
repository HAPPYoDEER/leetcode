package com.happydeer.problems;

public class ContainerWithMostWater {
	/**
	 * @origin: copy
	 * @taken: 7ms
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int size = height.length;
		int begin = 0;
		int end = size - 1;
		int maxArea = 0;
		int temp = 0;
		int min = 0;
		int max = 0;
		
		while(begin != end) {
			if (height[begin] > height[end]) {
				temp = (end - begin) * height[end];
				end --;
			}else {
				temp = (end - begin) * height[begin];
				begin ++;
			}
			if (temp >= maxArea) {
				maxArea = temp;
			}
		}
		return maxArea;
	}
}
