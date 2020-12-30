package q1;

/**
 * 121. Best Time to Buy and Sell Stock
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class L121_MaxProfit {
    /**
     * 方法一：动态规划
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 动态规划
     *  1) 状态定义
     *      dp[i][0] 卖出最高利润
     *      dp[i][1] 当前最低价
     *  2) 初始状态
     *      dp[0][0] = prices[0];
     *      dp[0][1] = prices[1];
     *  3) 状态转移方程
     *      dp[i][0] = max(prices[i] - dp[i - 1][1], dp[i - 1][0]);
     *      dp[i][1] = min(dp[i - 1][1], prices[i]);
     *  4) 返回值
     *      dp[prices.length - 1][0];
     */
    public int maxProfit_1(int[] prices) {
        if (prices == null) return 0;
        int len = prices.length;
        if (len == 0) return 0;
        /*
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(prices[i] - dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.min(dp[i - 1][1], prices[i]);
        }
        return dp[len - 1][0];
        */
        // 空间压缩
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    /**
     * 方法二：暴力双循环
     * Time: O(n^2)
     * Space: O(1)
     * 解题关键：
     * 1. 双循环一一比对，找出最大差额
     */
    public int maxProfit_2(int[] prices) {
        if (prices == null) return 0;

        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
