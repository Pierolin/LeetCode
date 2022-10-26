package q8;

import share.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * Linked List Components
 * https://leetcode.cn/problems/linked-list-components/
 */
public class L817_NumComponents {

    /**
     * 方法一：数组哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int numComponents_2(ListNode head, int[] nums) {
        int count = 0;
        boolean[] dict = new boolean[10001];
        for (int num : nums) dict[num] = true;
        boolean prevIsInDict = false;
        while (head != null) {
            if (dict[head.val]) {
                if (!prevIsInDict) count++;
                prevIsInDict = true;
            } else {
                prevIsInDict = false;
            }
            head = head.next;
        }
        return count;
    }

    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int numComponents_1(ListNode head, int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        boolean containPrev = false;
        while (head != null) {
            int num = head.val;
            if (set.contains(num)) {
                if (!containPrev) count++;
                containPrev = true;
                set.remove(num);
                if (set.isEmpty()) return count;
            } else {
                containPrev = false;
            }
            head = head.next;
        }
        return count;
    }
}
