package q18;

/**
 * 1800. 最大升序子数组和
 * Maximum Ascending Subarray Sum
 * https://leetcode.cn/problems/maximum-ascending-subarray-sum/solution/
 */
public class L1800_MaxAscendingSum {
    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int maxAscendingSum(int[] nums) {
        int tmpSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tmpSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, tmpSum);
                tmpSum = nums[i];
            }
        }
        maxSum = Math.max(maxSum, tmpSum);
        return maxSum;
    }
}
