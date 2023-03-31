package q23;

import java.util.Arrays;

public class L2389_AnswerQueries {

    /**
     * 方法一：贪心 + 排序 + 前缀和 + 二分查找
     * TC:
     * SC:
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] answers = new int[m];
        long[] preSums = new long[n + 1];
        Arrays.sort(nums);
        for (int i = 1; i < n + 1; i++) preSums[i] = preSums[i - 1] + nums[i - 1];
        for (int i = 0; i < m; i++) answers[i] = binarySearch(preSums, queries[i]);
        return answers;
    }

    private int binarySearch(long[] nums, int target) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long num = nums[mid];
            if (num == target) return mid;
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
