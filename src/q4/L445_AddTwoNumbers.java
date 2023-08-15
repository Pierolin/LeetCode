package q4;

import share.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii
 */
public class L445_AddTwoNumbers {
    /**
     * 方法一: 反转字符串
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        char[] chars1 = sb1.reverse().toString().toCharArray();
        char[] chars2 = sb2.reverse().toString().toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;
        int n = Math.max(n1, n2);
        ListNode sumNode = null;
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int val = carry;
            if (i < n1) val += chars1[i] - '0';
            if (i < n2) val += chars2[i] - '0';
            carry = val / 10;
            val = val % 10;
            sumNode = new ListNode(val, sumNode);
        }
        if (carry > 0)  sumNode = new ListNode(carry, sumNode);
        return sumNode;
    }

    /**
     * 方法二: 栈
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        //Stack<Integer> s1 = new Stack<>();
        //Stack<Integer> s2 = new Stack<>();
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode sumNode = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int val = carry;
            if (!s1.isEmpty()) val += s1.pop();
            if (!s2.isEmpty()) val += s2.pop();
            carry = val / 10;
            val %= 10;
            sumNode = new ListNode(val, sumNode);
        }
        return sumNode;
    }

    /**
     * 方法三: 反转链表 + 递归
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode addTwoNumbers_3(ListNode l1, ListNode l2) {
        l1 = reverseListNodeByRecur(l1);
        l2 = reverseListNodeByRecur(l2);
        ListNode l3 = addTwoByRecur(l1, l2, 0);
        return reverseListNodeByRecur(l3);
    }
    /**
     * 方法四: 反转链表 + 迭代
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode addTwoNumbers_4(ListNode l1, ListNode l2) {
        l1 = reverseListNodeByIterate(l1);
        l2 = reverseListNodeByIterate(l2);
        ListNode l3 = addTwoByIterate(l1, l2);
        return reverseListNodeByIterate(l3);
    }

    private ListNode addTwoByIterate(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode curr = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            carry = val / 10;
            val = val % 10;
            curr.val = val;
            if (l1 != null || l2 != null) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return l3;
    }

    private ListNode addTwoByRecur(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return (carry > 0 ? new ListNode(carry) : null);
        int val = carry;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        carry = val / 10;
        val = val % 10;
        return new ListNode(val, addTwoByRecur(l1, l2, carry));
    }

    private ListNode reverseListNodeByRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListNodeByRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode reverseListNodeByIterate(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            newHead = new ListNode(head.val, newHead);
            head = head.next;
        }
        return newHead;
    }
}
