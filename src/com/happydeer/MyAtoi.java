package com.happydeer;

public class MyAtoi {
	/**
	 * 运行时间：45ms
	 * 
	 * @param str 输入合法性参考gcc中atoi函数
	 *            
	 * @return
	 * 
	 * 总结：与大神比，我添加对非纯数字字符串的校验，完全贴合gcc中的atoi规范
	 *      leetcode测试用例应该都是纯数字字符串（包括‘+’，‘-’），运行时间不算校验非法数字字符，故还是比较落后
	 *      gcc的atoi函数， 忽视字符串开始的空格，然后识别数字，直到出现非法字符，停止识别
	 *      （ps：个人认为gcc的这个不怎么合理，leetcode上的约束对较为合理，
	 *      出现非法字符（加号，减号除外）则认为为非法字符串，不做处理，返回0）
	 */
	public static int myAtoi(String str) {
		int len = str.length();
        if(len==0)return 0;
		char[] chars = str.toCharArray();
		String INT;
		int start = 0, end;
		while (start < len && ((byte) chars[start]) == 32)
			start++;// 32为空格
		end = start;
		if ((byte) chars[end] == 45||(byte) chars[end] == 43)
			end++;// 45为减号 43为加号
		while (end < len && (byte) chars[end] >= 48 && (byte) chars[end] <= 57) {
			end++;
		}
		len = end - start;
		if (len == 0 || (len == 1 && ((byte)chars[start] == 45||(byte) chars[start] == 43)))  {
			System.out.println("ok");
			return 0;
		} else {
			long rs;
			if ((byte) chars[start] == 45) {
				INT = str.substring(start + 1, end);
				char[] charsINT = INT.toCharArray();
				rs = -getInt(charsINT);
				if(rs<Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				else return (int)rs;
			} else if((byte) chars[start] == 43){
				INT = str.substring(start + 1, end);
				char[] charsINT = INT.toCharArray();
				rs = getInt(charsINT);
                if(rs>Integer.MAX_VALUE)return Integer.MAX_VALUE;
                else return (int)rs;
			}else {
				System.out.println("ok");
				INT = str.substring(start, end);
				char[] charsINT = INT.toCharArray();
				rs = getInt(charsINT);
                if(rs>Integer.MAX_VALUE)return Integer.MAX_VALUE;
                else return (int)rs;
			}
		}

	}

    private static long getInt(char[] chars) {
		int len = chars.length;
		long result = 0;
		for (int i = len - 1; i >= 0; i--) {
			result += ((byte) chars[i] - 48) * Math.pow(10, len - i - 1);
		}
		return result;
	}
    /**
     * 大神作品
     * 运行时间：35ms
     * @param args
     */
    public int myAtoi2(String str) {
		if (str == null || "".equals(str)) return 0;
		str = str.trim();
		int sign = 1;
		if (str.startsWith("-")) {
			str = str.substring(1);
			sign = -1;
		} else if( str.startsWith("+")) {
			str = str.substring(1);
			sign = 1;
		}
		int base = 0;
		int i=0;
		while( i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && (str.charAt(i)-'0')>7)) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			base = base * 10 + (str.charAt(i++)-'0');
		}
        return sign*base;
	}
	public static void main(String[] args) {
		// System.out.println((byte)'9');
//		 System.out.println((byte)'+');
		System.out.println("begin");
		System.out.println("int:" + myAtoi("2147483648"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println("end");
	}
}
