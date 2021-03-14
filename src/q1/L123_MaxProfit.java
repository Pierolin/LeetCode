package q1;

public class L123_MaxProfit {
    /**
     * 方法一：动态规划
     * Time: O(n)
     * Space: O(1)
     * 解题关键：
     * 1. 第 i 天的 4 种如下可能状态，取某种状态的最大值：
     *   1) 第 1 次买；
     *   2) 第 2 次卖；
     *   3) 第 2 次买；
     *   4) 第 2 次卖。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}

