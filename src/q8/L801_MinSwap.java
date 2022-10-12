package q8;

/**
 * 801. 使序列递增的最小交换次数
 * Minimum Swaps To Make Sequences Increasing
 * https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class L801_MinSwap {

    /**
     * 方法二：动态规划
     * TC: O(n)
     * SC: O(1)
     */
    public int minSwap_2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = n;
            dp[i][1] = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 方法一：动态规划
     * TC: O(n)
     * SC: O(n)
     */
    public int minSwap_1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int minNoSwap = 0;
        int minSwap = 1;

        for (int i = 1; i < n; i++) {
            int tmpNoSwap = n;
            int tmpSwap = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                tmpNoSwap = minNoSwap;
                tmpSwap = minSwap + 1;
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                tmpNoSwap = Math.min(tmpNoSwap, minSwap);
                tmpSwap = Math.min(tmpSwap, minNoSwap + 1);
            }
            minNoSwap = tmpNoSwap;
            minSwap = tmpSwap;
        }

        return Math.min(minNoSwap, minSwap);
    }
}
