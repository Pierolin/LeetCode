public class L24_SwapPairs {
    /**
     * 方法一：递归
     * TC: O(n)
     * Sc: O(n)
     * 解题关键：
     *  1. 交换前 2 个节点，第 3 个节点开始新一轮的递归
     */
    public ListNode swapParis_1(ListNode head) {
        if (head != null && head.next != null) {
            ListNode currentNode = head;
            ListNode nextNode = head.next;
            ListNode nextNextNode = head.next.next;

            head = nextNode;
            head.next = currentNode;
            head.next.next = swapParis_1(nextNextNode);
        }

        return head;
    }

    /**
     * 方法二：迭代法
     */
    public ListNode swapParis_2(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next !=null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
