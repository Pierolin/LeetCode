package q28;

import share.ListNode;

/**
 * 2816. Double a Number Represented as a Linked List
 * 翻倍以链表形式表示的数字
 */
public class L2816_DoubleIt {
    /**
     * 方法一：由后向前进位法
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode doubleIt_1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        ListNode doubleNode = null;
        boolean isCarried = false;
        for (char c : sb.reverse().toString().toCharArray()) {
            int d = c - '0';
            int val = d * 2 % 10 + (isCarried ? 1 : 0);
            doubleNode = new ListNode(val, doubleNode);
            isCarried = d > 4;
        }
        if (isCarried) doubleNode = new ListNode(1, doubleNode);
        return doubleNode;
    }

    /**
     * 方法二：由前向后进位法
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode doubleIt_2(ListNode head) {
        ListNode doubleHead = new ListNode();
        ListNode curr = doubleHead;
        if (head.val > 4) {
            doubleHead.val = 1;
            doubleHead.next =  new ListNode();
            curr = doubleHead.next;
        }

        while (head != null) {
            curr.val = head.val * 2 % 10;
            if (head.next != null) {
                if (head.next.val > 4) curr.val++;
                curr.next = new ListNode();
            }
            curr = curr.next;
            head = head.next;
        }
        return doubleHead;
    }

    /**
     * 方法三：由前向后进位法
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode doubleIt_3(ListNode head) {
        if (head.val > 4) head = new ListNode(0, head);
        for (ListNode curr = head; curr != null; curr = curr.next) {
            curr.val = curr.val * 2 % 10;
            if (curr.next != null && curr.next.val > 4) curr.val++;
        }
        return head;
    }
}
