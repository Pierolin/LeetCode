package q9;

/**
 * 915. 分割数组
 * Partition Array into Disjoint Intervals
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */
public class L915_PartitionDisjoint {
    /**
     * 方法一：一次遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int partitionDisjoint(int[] nums) {
        int left = 1;
        int currMax = nums[0];
        int leftMax = currMax;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < leftMax) {
                left = i + 1;
                if (currMax > leftMax) leftMax = currMax;
            } else {
                currMax = Math.max(currMax, nums[i]);
            }
        }
        return left;
    }
}
