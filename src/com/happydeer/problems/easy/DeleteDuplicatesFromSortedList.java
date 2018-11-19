package com.happydeer.problems.easy;

/**
 *
 *作者：HCK
 *创建日期：2018年11月20日
 */
public class DeleteDuplicatesFromSortedList {
	
	/**
	 * done by myself, feel ok
	 * @param head
	 * @return
	 */
	public static ListNode solution(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p, q;
		p = head;
		q = head.next;
		while(q != null) {
			ListNode t = q;
			if (p.val == q.val) {
				q = t.next;
				p.next = q;
			} else {
				q = t.next;
				p = t;
			}
		}
		return head;
	}
	
	public static ListNode goodSolution(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.val == head.next.val) {
			return goodSolution(head.next);
		} else {
			head.next = goodSolution(head.next);
			return head;
		}
	}
	
	public static ListNode otherSolution(ListNode head) {
		ListNode curr = head;
		while (curr != null && curr != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}
}
