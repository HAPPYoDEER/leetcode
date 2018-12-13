package com.happydeer.problems.easy;

import java.util.LinkedList;

import com.happydeer.datastructure.TreeNode;

/**
 *
 *作者：HCK
 *创建日期：2018年11月22日
 */
public class SymmetricTree {
	
	/**
	 * 迭代
	 * @param root
	 * @return
	 */
	public static boolean solution(TreeNode root) {
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		queue.add(root);
		
		TreeNode left, right;
		while (queue.size() > 1) {
			left = queue.pop();
			right = queue.pop();
			
			if (null == left && null == right) {
				continue;
			}
			
			if (null == left || null == right) {
				return false;
			} 
			
			if (left .val != right.val) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		
		return true;
	}
	
	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static boolean solution2(TreeNode root) {
		return isMirror(root, root);
	}
	
	private static boolean isMirror(TreeNode t1, TreeNode t2) {
		if (null == t1 && null == t2) {
			return true;
		}
		
		if (null == t1 || null == t2) {
			return false;
		}
		
		return (t1.val == t2.val) &&
				isMirror(t1.left, t2.right) &&
				isMirror(t1.right, t2.left);
	}
}
