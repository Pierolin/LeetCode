package q16;

import share.ListNode;

import java.util.List;

/**
 * 1669. 合并两个链表
 * Merge In Between Linked Lists
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 */
public class L1669_MergeInBetween {
    /**
     * 方法一：模拟法
     * TC: O(n)
     * SC: O(1)
     */
    public ListNode mergeInBetween_1(ListNode list1, int a, int b, ListNode list2) {
        ListNode list = list1;
        int i = 0;
        while (list1.next != null) {
            if (++i == a) {
                ListNode old = list1.next;
                list1.next = list2;
                while (old != null) {
                    if (i++ == b) {
                        while (list1.next != null) list1 = list1.next;
                        list1.next = old.next;
                        break;
                    }
                    old = old.next;
                }
                break;
            }
            list1 = list1.next;
        }
        return list;
    }

    /**
     * 方法二：模拟法
     * TC: O(n)
     * SC: O(1)
     */
    public ListNode mergeInBetween_2(ListNode list1, int a, int b, ListNode list2) {
        ListNode root = list1;
        for (int i = 0; i < a - 1; i++) list1 = list1.next;
        ListNode old = list1.next;
        for (int i = a; i <= b; i++) old = old.next;
        list1.next = list2;
        while (list1.next != null) list1 = list1.next;
        list1.next = old;
        return root;
    }
}
