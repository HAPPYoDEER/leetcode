package com.happydeer.util;

/**
 *
 *作者：HCK
 *创建日期：2018年6月27日
 */
public class ClassicMath {
	
	
    /** 
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1 
     * 限制:整形 n <= 12
     *         长整型long: n <= 20
     * @param n 
     * @return 
     */ 
    public static int factorial(int n) {  
        return (n > 1) ? n * factorial(n - 1) : 1;  
    }  
  
    /** 
     * 计算排列数，即A(n, m) = n!/(n-m)! 
     * @param n 
     * @param m 
     * @return 
     */  
    public static int arrangement(int n, int m) {  
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;  
    }  
  
    /** 
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!) 
     * @param n 
     * @param m 
     * @return 
     */  
    public static int combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;  
    }  
}
