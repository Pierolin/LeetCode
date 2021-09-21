package q2;

import share.ListNode;

public class L206_ReverseList {

    /**
     * 方法一：迭代法
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 创建 3 个节点：前结点、当前结点、后结点
     * 2. 以上 3 结点相互赋值替换
     */
    public ListNode reverseList_1(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    /**
     * 方法二：递归法
     * Time: O(n)
     * Space: O(n)
     * 解题关键：
     * 1. 有些不太明白
     */
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = reverseList_2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
