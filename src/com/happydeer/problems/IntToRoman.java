package com.happydeer.problems;

/**
 *
 * 作者：HCK 创建日期：2018年3月30日
 */
public class IntToRoman {

	/**
	 * 很正经的一种做法
	 * 
	 * @param num
	 * @return
	 */
	public String solution(int num) {
		String result = "";
		char roman[] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int value[] = { 1000, 500, 100, 50, 10, 5, 1 };
		for (int n = 0; n < 7; n += 2) {
			int x = num / value[n];
			if (x < 4) {
				for (int i = 1; i <= x; ++i) {
					result += roman[n];
				}
			} else if (x == 4) {
				result = result + roman[n] + roman[n - 1];
			} else if (x > 4 && x < 9) {
				result += roman[n - 1];
				for (int i = 6; i <= x; ++i) {
					result += roman[n];
				}
			} else if (x == 9) {
				result = result + roman[n] + roman[n - 2];
			}
			num %= value[n];
		}
		return result;
	}

	/**
	 * 相比于解法一，首先确定范围，再进行转换，做了和很好的优化，还有StringBuilder的使用
	 * 
	 * @param num
	 * @return
	 */
	public String solution2(int num) {
		//对于非法数字的过滤，极大地节省时间		
		if (num <= 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		String[] dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/*		for (int i = 0; i < values.length; i++) {
			if (num >= values[i]) {
				int count = num / values[i];
				num = num % values[i];
				for (int j = 0; j < count; j++) {
					result.append(dict[i]);
				}
			}
		}*/
		for(int i = 0; i < values.length && num > 0; i++) {
            if(num < values[i])
                continue;
            while(num >= values[i]){
                num -= values[i];
                result.append(dict[i]);
            }
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(new IntToRoman().solution2(2));
	}
}
