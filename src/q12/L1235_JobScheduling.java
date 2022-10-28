package q12;

import java.util.Arrays;

/**
 * 1235. 规划兼职工作
 * Maximum Profit in Job Scheduling
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
 */
public class L1235_JobScheduling {
    /**
     * 方法一：动态规划 + 二分法
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n + 1];
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        for (int i = 1; i <= n; i++) {
            int j = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[j] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (jobs[mid][1] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
