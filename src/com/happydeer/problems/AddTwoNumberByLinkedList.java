package com.happydeer.problems;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}

public class AddTwoNumberByLinkedList {

	/**
	 * yy一下，我可能写了一推伪代码
	 * 说实话，我也不知道自己写的是一坨什么屎，出现一个理解不了的空指针异常
	 * 说实话，通过这题感觉java语法基础还很差，对数据结构的理解可能也有偏差
	 * @param l1  该是第一个链表的头结点（现在我连这个都不敢确认了）
	 * @param l2 第二个链表的头结点
	 * @return 想返回新链表的头结点
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3,l4;
		l3 = new ListNode(0);
		l3.next = null;
		l4 = l3;
		while(null != l1.next || null != l2.next) {//在leetcode上提交，此行出现NullPointException,很绝望
			if(l1 != null && l2 != null) {
				l4.val = l1.val;
				l1 = l1.next;
			}else if(l1 == null && l2 != null) {
				l4.val = l2.val;
				l2 =l2.next;
			}else {
				l4.val = (l1.val+l2.val)%10;
				l1 = l1.next;
				l1.val = (l1.val+l2.val)%10;
				l2 = l2.next;
			}
			l4 = l4.next;
			l4 = new ListNode(0);
			l4.next = null;
		}
		return l3;
	}
	
	
	/**
	 * 大神答案1 转自https://segmentfault.com/a/1190000002986101
	 * 运行时间69ms
	 * 方法归纳：递归
	 * 时间复杂度：O（n）
	 * 空间复杂度：n 递归栈空间
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null){
            return carry == 0? null : new ListNode(carry);
        }
        if(l1==null && l2!=null){
            l1 = new ListNode(0);
        }
        if(l2==null && l1!=null){
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helper(l1.next, l2.next, sum / 10);
        return curr;
    }
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 大神答案2 转自https://segmentfault.com/a/1190000002986101
	 * 运行时间还是69ms  
	 * 方法归纳：迭代
	 * 时间复杂度：O（n）
	 * 空间复杂度：1
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        if(l1 == null && l2 == null){
            return dummyHead;
        }
        int sum = 0, carry = 0;
        ListNode curr = dummyHead;
        while(l1!=null || l2!=null){
            int num1 = l1 == null? 0 : l1.val;
            int num2 = l2 == null? 0 : l2.val;
            sum = num1 + num2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
        

    }
    /**
     * 对比大神的俩种解体思路，我的思路该属于迭代法（自己找虐），
     * 由于对自己的代码还有点怀念，决定根据大神的解法坐下修改
     * 
     * 思想漏洞：（1）没有考虑俩个节点都为空的情况，（2）判断每个链表是否下个节点作为条件，
     * 	     好像有点超前，我这中思想是不来自迭代器中的hasNext()?,我现在的逻辑还还没告诉我
     *    其中的错误地方(3)在进位的时候好像修改了原来的链表，这该是个大错误(4)
     *    
     * 参考大神的解法2.修改自己的代码，结果虽然代码冗余很大，但是速度提升至49ms，很开心
     *  
     */
	public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
		ListNode l4 = l3;
        int sum =0,carry =0;
		if(l1 == null && l2 == null) {
			return l3;
		}
		
		while(l1 != null || l2 != null) {
            l4.next = new ListNode(carry);
            l4 = l4.next;
			if(l1 != null && l2 == null) {
                sum = carry+l1.val;
				l4.val = sum%10;
                carry = sum/10;
				l1 = l1.next;
			}else if(null == l1 && l2 != null) {
                sum = carry+l2.val;
				l4.val = sum%10;
                carry = sum/10;
				l2 = l2.next;
			}else {
                sum = l1.val+l2.val+carry;
				l4.val = sum%10;
                carry = sum/10;
				l1 = l1.next;
				l2 = l2.next;
			}
		}
        if(carry != 0){
            l4.next = new ListNode(carry);      
        }
		return l3.next;
	}
    

}
