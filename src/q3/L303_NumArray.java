package q3;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class L303_NumArray {
    int[] sums;

    public L303_NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    /*
    public L303_NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int n = i; n <= j; n++) {
            sum += this.nums[n];
        }
        return sum;
    }
     */
}
