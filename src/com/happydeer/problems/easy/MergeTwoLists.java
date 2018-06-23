package com.happydeer.problems.easy;

/**
 *
 * 作者：HCK 创建日期：2018年6月22日
 */
public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode l1, l2, end1, end2, l3;
		l1 = new ListNode(1);
		end1 = new ListNode(2);
		l1.next = end1;
		end1 = new ListNode(4);
		(l1.next).next = end1;
		l2 = new ListNode(1);
		end2 = new ListNode(3);
		l2.next = end2;
		end2 = new ListNode(4);
		(l2.next).next = end2;
		print(l1);
		print(l2);
		l3 = mySolution(l1, l2);
		print(l3);

	}

	private static int count = 1;

	public static void print(ListNode l) {
		System.out.println();
		System.out.print("l" + count++ + ": ");
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
		System.out.println("end");
	}

	/**
	 * 将一个链表表插入另一个链表失败，参考网上解法：创建新的节点，将两个链表的节点依次添加到新的链表中
	 * 
	 * @param l1
	 *            第一个链表的头节点
	 * @param l2
	 *            第二个链表的头节点
	 * @return 新的链表的头节点
	 */
	public static ListNode mySolution(ListNode l1, ListNode l2) {

		// 考虑l1或l2为null的情况
		if (l1 == null & l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		// 考虑直接拼接的俩种极端情况
		// ListNode end1 = l1, end2 = l2;
		// while (end1.next != null) {
		// end1 = end1.next;
		// }
		// if (end1.val <= l2.val) {
		// end1.next = l2;
		// return l1;
		// }
		// while (end2.next != null) {
		// end2 = end2.next;
		// }
		// if (end2.val <= l1.val) {
		// end2.next = l1;
		// return l2;
		// }
		// 其余情况采取采取，将一个列表的元素依次插入另一个列表的方法
		//
		// ListNode newListHead = null, prev = null;
		// if (l2.val < l1.val) {
		// newListHead = l2;
		// prev = l2;
		// prev.next = l1;
		// } else {
		// newListHead = l1;
		// prev = l1;
		// l1 = l1.next;
		// }
		//
		// while (l2 != null) {
		// ListNode tmp1 = l1, tmp2 = l2;
		// if (tmp2.val < tmp1.val) {
		// if (tmp2.next == null) {
		// prev.next = tmp2;
		// tmp2.next = tmp1;
		// break;
		// } else {
		// prev.next = tmp2;
		// tmp2.next = tmp1;
		// prev = tmp2;
		// }
		// l2 = l2.next;
		// } else {
		// if (tmp1.next == null) {
		// tmp1.next = l2;
		// break;
		// } else {
		// l1 = l1.next;
		// prev = prev.next;
		// }
		// }
		// }

		ListNode pa = null, pb = null, pc = null, l3 = null;
		l3 = new ListNode(0);
		for (pc = l3, pa = l1, pb = l2; pa != null & pb != null; pc = pc.next) {
			if (pa.val < pb.val) {
				pc.next = pa;
				pa = pa.next;
			} else {
				pc.next = pb;
				pb = pb.next;
			}

		}

		if (pa != null)
			pc.next = pa;
		else
			pc.next = pb;
		pc = l3;
		l3 = l3.next;
		return l3;

	}

	/**
	 * 递归解法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode bestSolution(ListNode l1, ListNode l2) {
		// 判断到某个链表为空就返回另一个链表。如果两个链表都为空呢？没关系，这时候随便返回哪个链表，不也是空的吗?
		if (l1 == null)
			return l2; 
		if (l2 == null)
			return l1;
		ListNode list0 = null;// 定义一个链表作为返回值
		if (l1.val < l2.val) {// 判断此时的值，如果list1比较小，就先把list1赋值给list0，反之亦然
			list0 = l1;
			list0.next = bestSolution(l1.next, l2);// 做递归，求链表的下一跳的值
		} else {
			list0 = l2;
			list0.next = bestSolution(l1, l2.next);
		}
		return list0;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
