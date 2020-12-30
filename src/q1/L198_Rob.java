package q1;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class L198_Rob {
    /**
     * 方法一：动态规划
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. dp[i] = max(dp[i - 1], dp[i -2] + nums[i])
     * 2. 状态压缩为 previous 和 max 即可。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int previous = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(max, previous + nums[i]);
            previous = temp;
        }
        return max;
    }
}
