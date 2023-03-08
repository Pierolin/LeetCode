package offer1;

/**
 * 剑指 Offer 47. 礼物的最大价值 LCOF
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 */
public class O47_MaxValue {

    /**
     * 方法一：动态规划 (二维数组)
     * TC: O(n)
     * SC: O(n)
     */
    public int maxValue_1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                dp[r][c] = grid[r - 1][c - 1] + Math.max(dp[r - 1][c], dp[r][c - 1]);
            }
        }
        return dp[rows][cols];
    }

    /**
     * 方法一：动态规划 (一维数组)
     * TC: O(n)
     * SC: O(1)
     */
    public int maxValue_2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                dp[c] = grid[r - 1][c - 1] + Math.max(dp[c - 1], dp[c]);
            }
        }
        return dp[cols];
    }

    /**
     * 方法一：动态规划 (原地修改)
     * TC: O(n)
     * SC: O(1)
     */
    public int maxValue_3(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) continue;
                if (r == 0) {
                    grid[r][c] += grid[r][c - 1];
                } else if (c == 0) {
                    grid[r][c] += grid[r - 1][c];
                } else {
                    grid[r][c] += Math.max(grid[r - 1][c], grid[r][c - 1]);
                }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
