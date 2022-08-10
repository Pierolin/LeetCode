package q14;

/**
 * 1413. 逐步求和得到正数的最小值
 * Minimum Value to Get Positive Step by Step Sum
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class L1413_MinStartValue {
    /**
     * 方法一：模拟补差
     * 遍历数组求和，一旦发现小于 1 即给开始值补差使当前和为 1。
     * TC: O(n)
     * SC: O(1)
     */
    public  int minStartValue(int[] nums) {
        int start = 1;
        if (nums == null || nums.length == 0) return start;

        int sum = start;
        for (int num : nums) {
            sum += num;
            if (sum < 1) {
                start += 1 - sum;
                sum = 1;
            }
        }
        return start;
    }
}
