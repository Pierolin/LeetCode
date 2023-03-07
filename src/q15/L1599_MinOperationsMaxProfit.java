package q15;

/**
 * 1599. 经营摩天轮的最大利润
 * Maximum Profit of Operating a Centennial Wheel
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel
 */
public class L1599_MinOperationsMaxProfit {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotates = -1;
        int n = customers.length;
        int waiting = 0;
        int currProfit = 0;
        int maxProfit = 0;

        for (int i = 0; i < n || waiting > 0; i++) {
            if (i < n) waiting += customers[i];
            int people = Math.min(4, waiting);
            currProfit += people * boardingCost - runningCost;
            waiting -= people;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                rotates = i + 1;
            }
        }

        return rotates;
    }
}
