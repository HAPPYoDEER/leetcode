package com.happydeer.contest.week_90;

/**
 *
 * 作者：HCK 创建日期：2018年6月24日
 */
public class BuddyStrings {
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean mySolution(String A, String B) {
		if ((A == null || "".equals(A)) | (B == null || "".equals(B))) {
			return false;
		}

		if (A.length() != B.length() | A.length() < 2 | B.length() < 2) {
			return false;
		}
		// 暴力解法，时间超限
		// for (int i = 0; i < A.length() - 1; i++) {
		// for (int j = i + 1; j < A.length(); j++) {
		// StringBuffer sb = new StringBuffer(A);
		// char c = sb.charAt(i);
		// sb.setCharAt(i, sb.charAt(j));
		// sb.setCharAt(j, c);
		// A = sb.toString();
		// if (A.equals(B)) {
		// return true;
		// }
		// }
		// }
		// return false;
		
		int len = A.length();
		//如果A与B的值相同，只要找出A中有重复字符，返回true，否则false；
		if (A.equals(B)) {
			for (int i = 0; i < len; i++) {
				if (A.lastIndexOf(A.charAt(i)) != i) {
					return true;
				} else {
					return false;
				}
			}
		} else {//如果A与B的之不同，找出A中前俩个不同字符的位置，交换俩个字符，与B比较，相同返回true，其余情况为false
			int diffNum = 0, a = 0, b = 0;
			for (int i = 0; i < len; i++) {
				if (A.charAt(i) != B.charAt(i)) {
					if (diffNum == 0)
						a = i;
					if (diffNum == 1)
						b = i;
					if (diffNum == 3)
						break;
					diffNum++;

				}
			}
			if (diffNum != 2) {
				return false;
			} else {
				StringBuffer sb = new StringBuffer(A);
				char c = sb.charAt(a);
				sb.setCharAt(a, sb.charAt(b));
				sb.setCharAt(b, c);
				A = sb.toString();
				if (A.equals(B)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "ab";
		StringBuffer sb = new StringBuffer(str);
		char c = sb.charAt(0);
		sb.setCharAt(0, sb.charAt(1));
		sb.setCharAt(1, c);
		// char c = arrA[0];
		// arrA[0] = arrA[1];
		// arrA[1] = c;
		// str.replace(str, new String(arrA));
		str = sb.toString();
		System.out.println(str);
	}
}
