package q8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * Shortest Subarray with Sum at Least K
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class L862_ShortestSubarray {
    /**
     * 方法二：前缀和 + 双端队列
     * TC: O(n)
     * SC: O(n)
     */
    public int shortestSubarray_2(int[] nums, int k) {
        int n = nums.length;
        int shortest = n + 1;
        long[] preSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSums[i];
            while (!deque.isEmpty() && curSum - preSums[deque.peekFirst()] >= k) {
                shortest = Math.min(shortest, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSums[deque.peekLast()] >= curSum) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return shortest == n + 1 ? -1 : shortest;
    }

    /**
     * 方法一：前缀和 + 暴力枚举 (超时)
     * TC: O(n^2)
     * SC: O(n)
     */
    public int shortestSubarray_1(int[] nums, int k) {
        int n = nums.length;
        if (nums[0] >= k) return 1;
        long[] preSums = new long[n + 1];
        for (int i = 0; i < n; i++) preSums[i + 1] = preSums[i] + nums[i];
        int shortest = n + 1;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSums[j] - preSums[i] >= k) {
                    shortest = Math.min(shortest, j - i);
                    break;
                }
            }
        }
        return shortest == n + 1 ? -1 : shortest;
    }
}
