package com.happydeer.problems.easy;

/**
 *
 *作者：HCK
 *创建日期：2018年9月11日
 */
public class AddBinary {
	public static void main(String[] args) {
		String a = "1011";
		String b = "1010";
		System.out.println(solution(a, b));
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String solution(String a, String b) {
		String result = "0";
		char[] binaryDigits1 = a.toCharArray();
		char[] binaryDigits2 = b.toCharArray();
		int aLen = a.length();
		int bLen = b.length();
		int len = Math.max(aLen, bLen);
		char[] binaryDigitsTarget = new char[len];
		boolean flag = true;
		int index = 1,carry = 0;
		while (flag) {
			if (index > a.length() && index > b.length()) {
				flag = false;
				if (carry == 1) {
					result = "1" + new String(binaryDigitsTarget);
					return result;
				}
			} else {
				int temp = 0, t1 = 0, t2 = 0;
				if (index <= aLen) {
					t1 = binaryDigits1[aLen - index] - 48;
				}
				if (index <= bLen) {
					t2 = binaryDigits2[bLen - index] - 48;
				}
				
				temp = t1 + t2 + carry;
				if (temp > 1) {
					carry = 1;
				} else {
					carry = 0;
				}
				binaryDigitsTarget[len - index] = (temp % 2 == 1 ? '1' : '0');
			}
			index++;
		}
		result = new String(binaryDigitsTarget);	
		return result;
	}
	
	/**
	 * 代码结构很漂亮
	 * @param a
	 * @param b
	 * @return
	 */
	private static String goodSolution(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		StringBuilder sb = new StringBuilder();
		int i = aLen - 1, j = aLen -1, carry = 0;
		while (i >= 0 || j >= 0) {
			int x = (i >= 0) ? a.charAt(i) - '0' : 0;
			int y = (j >= 0) ? b.charAt(j) - '0' : 0;
			int sum = x + y + carry;
			carry = sum / 2;
			sb.append(sum % 2);
			i--;
			j--;
		}
		if (carry == 1) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
