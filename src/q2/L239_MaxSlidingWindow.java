package q2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * Sliding Window Maximum
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 */
public class L239_MaxSlidingWindow {


    /**
     * 方法二：单调队列
     * TC: O(n)
     * SC: O(1)
     */
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        int n = nums.length;
        int[] maxes = new int[n - k + 1];
        int j = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!q.isEmpty() && q.peekLast()[1] <= num) q.pollLast();
            q.add(new int[]{i, num});
            if (i >= k - 1) {
                if (q.peekFirst()[0] <= i - k) q.pollFirst();
                maxes[j++] = q.peekFirst()[1];
            }
        }
        return maxes;
    }

    /**
     * 方法一：优先队列
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int n = nums.length;
        int[] maxes = new int[n - k + 1];
        int j = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, nums[i]});
            if (i >= k - 1) {
                while (q.peek()[0] <= i - k) q.poll();
                maxes[j++] = q.peek()[1];
            }
        }
        return maxes;
    }
}
