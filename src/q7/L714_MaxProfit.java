package q7;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class L714_MaxProfit {
    /**
     * 方法一：动态规划
     * Time: O(n)
     * Space: O(n) / O(n)
     * 解题思路
     * 1. 动态规划
     * 1) 定义状态：
     *    dp[i][0] = 卖出股票利润;
     *    dp[i][1] = 买入股票利润;
     * 2) 转移方程：
     *    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
     *    dp[i][1] = max(dp[i-1][1], dp[i - 1][0] - price[i]);
     * 3) 初始状态：
     *    dp[0][0] = 0;
     *    dp[0][1] = -prices[0];
     * 4) 返回结果：
     *    dp[len - 1][0];
     * 2. 状态压缩 / 空间优化: 只与前一天的买卖状态有关，
     *    sell = dp[i - 1][0];
     *    buy = dp[i - 1][1];
     */
    public int maxProfit_1(int[] prices, int fee) {
        if (prices == null) return 0;
        int len = prices.length;
        /*
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        */
        // 状态压缩 / 空间优化
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < len; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    /**
     * 方法二：贪心算法
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 将手续费放在卖出时进行计算;
     * 2. 当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
     */
    public int maxProfit_2(int[] prices, int fee) {
        if (prices == null) return 0;
        int profit = 0;
        int buy = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
                continue;
            }
            if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        L714_MaxProfit maxProfit = new L714_MaxProfit();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit.maxProfit_2(prices, fee));
    }
}
