package q8;

/**
 * 1827. 最少操作使数组递增
 * Minimum Operations to Make the Array Increasing
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/description/
 */
public class L1827_MinOperations {

    /**
     * 方法一：贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_2(int[] nums) {
        int min = 0;
        int curr = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curr = Math.max(curr, num);
            min += curr - num;
            curr++;
        }
        return min;
    }

    /**
     * 方法一：模拟法
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_1(int[] nums) {
        int min = 0;
        int curr = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < curr) {
                min += curr - num;
                curr++;
            } else {
                curr = num + 1;
            }
        }
        return min;
    }
}
