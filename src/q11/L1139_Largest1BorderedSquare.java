package q11;

/**
 * 1139. 最大的以 1 为边界的正方形
 * Largest 1-Bordered Square
 * https://leetcode.cn/problems/largest-1-bordered-square
 */
public class L1139_Largest1BorderedSquare {

    /**
     * 方法一：动态规划前缀和
     * TC: O(m*n*min(m, n))
     * SC: O(m*n)
     */
    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows + 1][cols + 1][2];

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (grid[r - 1][c - 1] == 0) continue;
                dp[r][c][0] = dp[r][c - 1][0] + 1;
                dp[r][c][1] = dp[r - 1][c][1] + 1;
            }
        }

        for (int r = rows; r > 0; r--) {
            if (max >= r) break;
            for (int c = cols; c > 0; c--) {
                if (max >= c) break;
                int side = Math.min(dp[r][c][0], dp[r][c][1]);
                while (side > max) {
                    if (dp[r - side + 1][c][0] >= side && dp[r][c - side + 1][1] >= side) {
                        max = side;
                        break;
                    }
                    side--;
                }
            }
        }

        return max * max;
    }
}
