package q3;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */

/**
 * 方法一：一维前缀和
 * Time: O(n)
 * Space: O(1)
 * 解题思路：
 * 1. 初始前缀和数组 sums
 * 2. sumRange[i~j] = sum[j] - sum[i-1]
 * 3. 要考虑 i = 0 的情况
 */
public class L303_NumArray {
    int[] sums;

    public L303_NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len];
        for (int i = 0; i < len; i++) {
            sums[i] = nums[i] + (i > 0 ? sums[i - 1] : 0);
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i > 0 ? sums[i - 1] : 0);
    }
}
/**
 * 方法一：暴力破解
 * Time: O(n)
 * Space: O(1)
 */
/*
public class L303_NumArray {
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
}
*/