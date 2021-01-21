package q6;

/**
 * 628. 三个数的最大乘积 (Maximum Product of Three Numbers)
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */

import java.util.Arrays;

public class L628_MaximumProduct {
    /**
     * 方法一：线性扫描法
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 要考虑到负负得正的情况;
     * 2. 找出 3 个最大数和 2 个最小数;
     */
    public int maximumProduct_1(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    /**
     * 方法二：排序法
     * Time: O(nlogn)
     * Space: O(1)
     * 解题思路：
     * 1. 先进行排序;
     * 2. 要考虑到负负得正的情况;
     */
    public int maximumProduct_2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - 1] * Math.max(nums[0] * nums[1], nums[len - 2] * nums[len - 3]);
    }

    /**
     * 方法三：暴力遍历 (超时)
     * Time: O(n^3)
     * Space: O(1)
     * 解题思路：
     * 1. 三次循环
     */
    public int maximumProduct_3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int n = j + 1; n < len; n++) {
                    max = Math.max(max, nums[i] * nums[j] * nums[n]);
                }
            }
        }
        return max;
    }
}
