package q14;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 * Maximum Product of Two Elements in an Array
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
public class L1464_MaxProduct {

    /**
     * 方法一：
     * TC: O(n)
     * SC: O(1)
     */
    public int maxProduct_3(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else {
                if (num > max2) max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    /**
     * 方法二：排序法
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maxProduct_2(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        return (nums[size - 2] - 1) * (nums[size - 1] - 1);
    }

    /**
     * 方法一：暴力枚举双循环
     * TC: O(n^2)
     * SC: O(1)
     */
    public int maxProduct_1(int[] nums) {
        int max = 0;
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                max = Math.max((nums[i] - 1) * (nums[j] - 1), max);
            }
        }
        return max;
    }
}
