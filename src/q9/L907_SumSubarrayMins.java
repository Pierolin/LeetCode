package q9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. 子数组的最小值之和
 * Sum of Subarray Minimums
 * https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class L907_SumSubarrayMins {
    private static final long MOD = (long) (1e9 + 7);

    /**
     * 方法二：单调栈 + 贡献值 + 1 次遍历
     * TC: O(n)
     * Sc: O(n)
     */
    public int sumSubarrayMins_3(int[] arr) {
        long sum = 0;
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int right = 0; right <= n; right++) {
            int curr = right < n ? arr[right] : 0;
            while (stack.size() > 1 && curr <= arr[stack.peek()]) {
                int i = stack.pop();
                int left = stack.peek();
                sum += (long) (i - left) * (right - i) * arr[i];
            }
            stack.push(right);
        }
        return (int) (sum % MOD);
    }

    /**
     * 方法二：单调栈 + 贡献值 + 3 次遍历
     * TC: O(n)
     * Sc: O(n)
     */
    public int sumSubarrayMins_2(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) stack.pop();
            left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) stack.pop();
            right[i] = stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) sum += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (sum % MOD);
    }

    /**
     * 方法一：暴力枚举 (超时)
     * TC: O(n^2)
     * SC: O(1)
     */
    public int sumSubarrayMins_1(int[] arr) {
        long sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            sum += min;
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum += (long) min;
            }
        }
        return (int) (sum % MOD);
    }
}
