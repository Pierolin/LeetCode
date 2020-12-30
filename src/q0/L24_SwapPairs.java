package q0;

import share.ListNode;

public class L24_SwapPairs {
    /**
     * 方法一：递归
     * TC: O(n)
     * Sc: O(n)
     * 解题关键：
     *  1. 交换前 2 个节点，第 3 个节点开始新一轮的递归
     */
    public ListNode swapPairs_1(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        ListNode nextNextNode = head.next.next;

        head = nextNode;
        head.next = currentNode;
        head.next.next = swapPairs_1(nextNextNode);

        return head;
    }

    /**
     * 方法二：迭代法
     * TC: O(n)
     * SC: O(1)
     */
    public ListNode swapPairs_2(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            ListNode node3 = temp.next.next.next;

            temp.next = node2;
            temp.next.next = node1;
            temp.next.next.next = node3;

            temp = temp.next.next;
        }

        return dummyNode.next;
    }
}


