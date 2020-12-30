package q0;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class L31_NextPermutation {
    /**
     * 方法一：两遍扫描
     * TC: O(n)
     * SC: O(1)
     * 解题思路:
     * 1. 从后往前遍历数组，找到第一个比后面小的数字 a;
     * 2. 再从后往前遍历数组，找到比 a 大的数字 b，a 和 b 交换位置;
     * 3. 现在 a 后面的数组元素是降序排列的，只要反转一下即变为升序排列即可。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        // 方法一：排序
                        // Arrays.sort(nums, i, len);
                        // 方法二：反转数组元素
                        reverse(nums, i, len - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
        //Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
