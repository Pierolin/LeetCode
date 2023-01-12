package q6;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * Minimum Operations to Reduce X to Zero
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 */
public class L1658_MinOperations {
    /**
     * 方法一：滑动窗口
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_1(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) return -1;
        if (sum == x) return n;

        int min = n;
        int left = 0;
        int right = 0;
        int leftSum = 0;
        int rightSum = sum;

        while (left <= n) {
            if (left > 0) leftSum += nums[left - 1];
            while (right < n && leftSum + rightSum > x) rightSum -= nums[right++];
            if (leftSum + rightSum == x) min = Math.min(min, left + (n - right));
            left++;
        }

        return min == n ? -1 : min;
    }
}
