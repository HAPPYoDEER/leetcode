package com.happydeer.problems.easy;

/**
 *
 * 作者：HCK 创建日期：2018年9月12日
 */
public class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(solution(38));
		
	}

	/**
	 * em。。。。
	 * @param n
	 * @return
	 */
	public static int solution(int n) {
		int result = 1;
		/**
		 * 2 (1,1)
		 * 3 (2,1)
		 * 4 (2,2) (3,1)
		 * 5 (3,2) (4,1)
		 * 6 (3,3) (4,2) (5,1)
		 * 7 (4,3) (5,2) (6,1)
		 */
		for (int i = (n / 2); i > 0; i--) {
//			System.out.println((n -i) + "-" + i);
			result += combination(n - i, i);
		}
		return result;
	}

	
	
	public static int combination(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
	}

	public static int factorial(int n) {
		return (n > 1) ? n * factorial(n - 1) : 1;
	}
	
	/**
	 * feel so awesome
	 * @param n
	 * @return
	 */
	public static int greatSolution(int n) {
		int a = 1;
		int b = 1;
		while (--n > 0) {
			b += a;
			a = b - a;
		}
		return b;
	}
}
