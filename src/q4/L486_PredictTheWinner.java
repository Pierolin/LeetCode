package q4;

/**
 * 486. Predict the Winner: 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 */
public class L486_PredictTheWinner {
    /**
     * 方法一：动态规划
     * Time: O(n^2)
     * Space:  O(n^2)
     * 解题思路：
     * 甲乙比赛，甲先手面对区间[i...j]时，dp[i][j]表示甲对乙的净胜分。     *
     * 最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。     *
     * 甲先手面对区间[i...j]时，     *
     *     如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
     *     如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。     *
     * 以上两种情况二者取大即可。
     */
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        // base code
        for (int i = 0; i < len - 1; i++) dp[i][i] = nums[i];

        // status, options & function
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }
}
