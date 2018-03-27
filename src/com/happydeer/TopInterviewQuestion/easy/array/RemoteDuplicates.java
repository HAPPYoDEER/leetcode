package com.happydeer.TopInterviewQuestion.easy.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
public class RemoteDuplicates {
	/*
	 * 问题：数组（已排好序）去重-Remote Duplicates from sorted array
	 * 要求：给定一个有序数组，删除重复内容，使每个元素只出现一次，并返回新的长度。
	 *     不要为其他数组分配额外的空间，您必须通过在O（1）额外的内存中就地修改输入数组
	 *     来实现这一点。
	 * 
	 * */	
	/**
	 * mind：利用java中Set的特性
	 * date: 18-1-10
	 * version:0
	 * pass:no
	 * analyze:虽说只返回长度，但题目似乎要求改变原数组？而且使用set好像不符合不要为数组分配额外的空间这一条件
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int result = nums.length;
		Set<Integer> set = new HashSet<>();
		for(int i:nums) {
			set.add(new Integer(i));
		}
		result = set.size();
		return result;
		
	}
	
	/**
	 * mind:由于数组已排好顺序。依次扫描去重（修改数组），
	 * date：18-1-10
	 * version:1
	 * pass:no
	 * analyze:去重的条件是遇到不重复的值，故最后一个重复值（出现在末尾的重复情况，或是这个数组是一个值的重复）无法去重
	 * @param nums
	 * @return
	 */
    public int removeDuplicates1(int[] nums) {
       	int result = nums.length;
		int count = 0;
		for(int i=1,curr=1;i<nums.length;i++) {
			if(nums[i]==nums[i-1]) {
				count++;
			}else {
				for(int j=curr;j<nums.length-1;j++) {
					nums[j] = nums[j+1];
				}
				result -= count;
				count=0;
				curr++;
			}
		}
		return result;
    }
    
	/**
	 * date：18-1-10
	 * version:1.1
	 * pass:no
	 * analyze: 去重代码好像错了
	 * @param nums
	 * @return
	 */
    public int removeDuplicates11(int[] nums) {
        int result = nums.length;
 		int count = 0;
 		for(int i=1,curr=1;i<=nums.length;i++) {
 			if(i<nums.length && nums[i]==nums[i-1]) {
 				count++;
 				continue;
 			}
 			for(int j=curr;j<nums.length-1;j++) {
 				nums[j] = nums[j+1];
 			}
 			result -= count;
 			count=0;
 			curr++;
 		}
 		return result;
     }
    
	/**
	 * mind:遍历两遍，第一遍标记重复元素，第二遍更新数组
	 * date：18-1-10
	 * version:2
	 * pass:no
	 * analyze:①标记是个问题，int不能是int
	 * @param nums
	 * @return
	 */
    public int removeDuplicates12(int[] nums) {
 		int result = nums.length;
 		int count = 1;
 		for(int i=1;i<nums.length;i++) {
 			if(nums[i]==nums[i-count]) {
 				nums[i] = -1;
 				result--;
 				count++;
 			}else {
 				count = 1;
 			}
 		}
 		for(int i=0,curr=0;i<nums.length;i++) {
 			if(nums[i]!=-1) {
 				nums[curr] = nums[i];
 				curr++;
 			}
 		}
 		return result;
 	}
    
    
	public int removeDuplicates13(int[] nums) {
		int result = nums.length;
		

		return result;
	}
	
	synchronized public void remove(int[] nums,int index) {
		if(index<nums.length-1) {
			for(int i=index;i<nums.length-1;i++) {
				nums[i] = nums[i+1];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,2,2,3,3,3,3,4,5,5,5,6};
		Set<Integer> set = new TreeSet<>();
		Set<Integer> set2 = new HashSet<>();
	/*	int len = new RemoteDuplicates().removeDuplicates12(nums);
		System.out.println("len:"+len+"  ");
		for(int i=0;i<len;i++) { 
			System.out.print(nums[i]+" ");
		}*/
		for(int i=0;i<nums.length;i++) {
			set.add(new Integer(nums[i]));
			set2.add(new Integer(nums[i]));
		}
		
		for(int i=0;i<6;i++) {
			 for(int x :set)System.out.print(x+" ");
//			 System.out.print("---");
//			 for(int y :set2)System.out.print(y+" ");
			 System.out.println();
		}
		
	}
}
