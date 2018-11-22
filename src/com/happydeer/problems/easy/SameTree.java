package com.happydeer.problems.easy;

import com.happydeer.datastructure.TreeNode;

/**
 *
 * 作者：HCK 创建日期：2018年11月22日
 */
public class SameTree {

	/**
	 * done by myself T.T
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p != null && q != null) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			} else {
				return false;
			}

		} else if (p == null && q == null) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * good format
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTreeG(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } 
        if (p == null ^ q == null) {//good stuff
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTreeG(p.left, q.left) && isSameTreeG(p.right, q.right);
    }
	
	public static void main(String[] args) {
		System.out.println(false ^ false);
		System.out.println(false ^ true);
		System.out.println(true ^ false);
		System.out.println(true ^ true);
	}
	
}
