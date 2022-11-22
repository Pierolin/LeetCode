package q8;

public class L808_SoupServings {
    /**
     * 方法一：动态规划
     * TC: O(C^2)
     * SC: O(C^2)
     */
    public double soupServings(int n) {
        n = (int) Math.ceil(n / 25D);
        if (n > 179) return 1L;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) dp[0][i] = 1D;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] +
                        dp[Math.max(0, i - 3)][Math.max(0, j - 1)] +
                        dp[Math.max(0, i - 2)][Math.max(0, j - 2)] +
                        dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) * 0.25;
            }

        }
        return dp[n][n];
    }
}
