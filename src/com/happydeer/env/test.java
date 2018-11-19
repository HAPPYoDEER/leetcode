package com.happydeer.env;

import com.happydeer.util.CommonUtils;

/**
 *
 * 作者：HCK 创建日期：2018年9月11日
 */
public class test {
	public static void main(String[] args) {
		test t = new test();
		int[] digits = {9, 9, 9};
		int[] result = t.plusOne(digits);
		CommonUtils.printList(result);
	}
    public int[] plusOne(int[] digits) {
		return plusOneSolution(digits, digits.length - 1);
	}

	private int[] plusOneSolution(int[] digits, int index) {
		if (digits[index] + 1 < 10) {
			digits[index] += 1;
			return digits;
		} else {
			if (index == 0) {
				int[] newDigits = new int[digits.length + 1];
				newDigits[0] = 1;
				newDigits[1] = 0;
				for (int i = 2; i < newDigits.length; i++) {
					newDigits[i] = digits[i - 1];
				}
				return newDigits;
			} else {
				digits[index] = 0;
				return plusOneSolution(digits, --index);
			}
		}

	}
}
