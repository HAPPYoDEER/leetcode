package com.happydeer.problems.easy;

import com.happydeer.util.CommonUtils;

/**
 *
 * 作者：HCK 创建日期：2018年9月11日
 */
public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {9, 9, 9};
		int[] result = solution(digits);
		CommonUtils.printList(result);
	}
	
	/**
	 * 额，思维僵化，强行用了递归
	 * @param digits
	 * @return
	 */
	public static int[] solution(int[] digits) {
		return plusOne(digits, digits.length - 1);
	}

	private static int[] plusOne(int[] digits, int index) {
		if (digits[index] + 1 < 10) {
			digits[index] += 1;
			return digits;
		} else {
			if (index == 0) {
				int[] newDigits = new int[digits.length + 1];
				newDigits[0] = 1;
				return newDigits;
			} else {
				digits[index] = 0;
				return plusOne(digits, --index);
			}
		}

	}
	
	/**
	 * 很实在的解法
	 * @param digits
	 * @return
	 */
	private static int[] otherSolution(int[] digits) {
		int len = digits.length;
		for (int i = len -1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				return digits;
			}
		}
		int[] newDigits = new int[len + 1];
		newDigits[0] = 1;
		return newDigits;
	}
}
