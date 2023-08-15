package q28;

/**
 * 2815. Max Pair Sum in an Array
 * 数组中的最大数对和
 * https://leetcode.cn/problems/max-pair-sum-in-an-array
 */
public class L2815_MaxSum {
    /**
     * 方法一：一次遍历
     * Time: O(nlogU)，其中 n 为 nums 的长度，U = max(nums)
     * Space: O(1)
     */
    public int maxSum(int[] nums) {
        int sum = -1;
        int[] maxes = new int[10];
        for (int num : nums) {
            int i = 0;
            int tmp = num;
            while (tmp > 0) {
                i = Math.max(i, tmp % 10);
                tmp = tmp / 10;
            }
            if (maxes[i] > 0 ) sum = Math.max(sum, num + maxes[i]);
            maxes[i] = Math.max(maxes[i] , num);
        }
        return sum;
    }
}
