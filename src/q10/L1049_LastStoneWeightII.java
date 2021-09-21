package q10;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 */
public class L1049_LastStoneWeightII {
    /**
     * 方法一：动态规划之01背包问题
     * Time:
     * Space:
     * 解题关键：
     * 1. 转化为背包问题
     */
    public int lastStoneWeighII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int rows = stones.length;
        int cols = sum / 2;

        int[][] dp = new int[rows + 1][cols + 1];
        for (int r = 1; r <= rows; r++) {
            int stone = stones[r - 1];
            for (int c = 0; c <= cols; c++) {
                dp[r][c] = dp[r - 1][c];
                if (c >= stone) {
                    dp[r][c] = Math.max(dp[r][c], dp[r - 1][c - stone] + stone);
                }
            }
        }

        return Math.abs(sum - dp[rows][cols] - dp[rows][cols]);

    }
}
