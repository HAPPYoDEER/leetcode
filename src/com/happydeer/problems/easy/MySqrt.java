package com.happydeer.problems.easy;

/**
 *
 * 作者：HCK 创建日期：2018年9月12日
 */
public class MySqrt {
	public static void main(String[] args) {
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}

	public static int solution(int x) {
		return (int)Math.sqrt(x);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public static int correctSolution(int x) {
		int low = 0, high = 46341, mid = 0;
		while (low <= high) {
			if (mid == low + (high - low) / 2) {
				return mid;
			}
			mid = low + (high - low) / 2;
			int square = mid * mid;
			if (square == x) {
				return mid;
			} else if (square > x) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return mid;
	}
}
