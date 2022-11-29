package q8;

/**
 * 813. 最大平均值和的分组
 * Largest Sum of Averages
 * https://leetcode.cn/problems/largest-sum-of-averages/
 */
public class L813_LargestSumOfAverages {
    /**
     * 方法一：前缀和 + 动态规划
     * TC: O(k×n^2)
     * SC: O(n)
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] preSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = preSum[i] / i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (preSum[i] - preSum[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
