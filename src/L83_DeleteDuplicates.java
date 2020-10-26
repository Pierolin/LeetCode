
/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class L83_DeleteDuplicates {
    /**
     * 方法三：快慢指针
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 设置快慢两个指针, 让快针先走一步，用以比较判断是否有与慢指针相等;
     * 2. 如果相等，快指针继续走;
     * 3. 如果不相等，慢指针直接指向快指针。
     */
    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    /**
     * 方法二：递归
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 当下一结点的值等于当前结点值时，把当前结点的下一结点设置为当前结点的下下结点;
     * 2. 不停递归调用直到链表末尾。
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_2(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 方法一：迭代法直接
     * TC: O(n)
     * SC: O(1)
     * 解题思路
     * 1. 设置哑结点 dummyNode 以便返回
     * 2. 当下一结点的值等于当前结点值时，把当前结点的下一结点设置为当前结点的下下结点
     */
    public ListNode deleteDuplicates_3(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }
}


