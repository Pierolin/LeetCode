package q6;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * Maximum Length of Pair Chain
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */
public class L646_FindLongestChain {
    /**
     * 方法二：贪心
     * TC: O(nlogn)
     * SC: O(logn)
     */
    public int findLongestChain_2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int current = Integer.MIN_VALUE;
        int longest = 0;
        for (int[] pair : pairs) {
            if (pair[0] > current) {
                longest++;
                current = pair[1];
            }
        }
        return longest;
    }
    /**
     * 方法二：动态规划
     * TC: O(n^2)
     * SC: O(n)
     */
    public int findLongestChain_1(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
