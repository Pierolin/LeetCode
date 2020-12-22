/**
 * 746. Min Cost Climbing Stairs
 * 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class L746_MinCostClimbingStairs {
    /**
     * 方法一：动态规划
     * Time : O(n)
     * Space: O(n) / O(1)
     * 解题关键：
     * 1. 到达当前台阶所要花费的精力等于到达前 1 级台阶和到达前 2 级台阶二者的最小值。
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) return 0;
        int len = cost.length;
        /*
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
        */
        // 空间压缩
        int min = 0;
        int pre1 = 0;
        int pre2 = 0;
        for (int i = 2; i <= len; i++) {
            min = Math.min(pre2 + cost[i - 2], pre1 + cost[i - 1]);
            pre2 = pre1;
            pre1 = min;
        }
        return min;
    }
}
