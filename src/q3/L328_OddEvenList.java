package q3;

import share.ListNode;

public class L328_OddEvenList {
    /**
     * 方法一：迭代法
     * TC: 0(n)
     * SC: 0(1)
     * 解题思路：
     * 1. 拆分为奇偶两个链表, 扩分完后偶链表接上奇链表
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
