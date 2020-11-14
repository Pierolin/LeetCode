/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class L122_MaxProfit {
    /**
     贪心算法: 高抛低吸
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 每天都可进行交易，[i-1] 代表昨天，[i] 代表今天;
     * 2. 只要今天比昨天的价格高，昨天就可买入，今天就可卖出，这样即可达到利润最大化。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i - 1];
            if (difference > 0) profit += difference;
        }
        return profit;
    }
}
