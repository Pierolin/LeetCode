package q16;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * Minimum Operations to Reduce X to Zero
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 */
public class L1658_MinOperations {

    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_1(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) return -1;
        if (sum == x) return n;

        int min = n;
        int l = 0;
        int r = 0;
        int lSum = 0;
        int rSum = sum;

        while (l <= n) {
            if (l > 0) lSum += nums[l - 1];
            while (r < n && lSum + rSum > x) rSum -= nums[r++];
            if (lSum + rSum == x) min = Math.min(min, l + (n - r));
            l++;
        }

        return min == n ? -1 : min;
    }

    /**
     * 方法二：逆向思维 + 双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_2(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target < 0) return -1;

        int max = -1;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > target) sum -= nums[l++];
            if (sum == target) max = Math.max(max, r - l + 1);
        }

        return max == -1 ? -1 : n - max;
    }
}
