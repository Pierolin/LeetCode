/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class L34_SearchRange {
    /**
     * 方法一：二分查找
     * Time： O(logn)
     * Space: O(1)
     * 解题思路：
     * 1. 二分查找分别找出目标值的的最左边索引和最右边索引
     */
    public int[] searchRange_1(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binaryFind(nums, target, true);
        result[1] = binaryFind(nums, target, false);
        return result;
    }

    private int binaryFind(int[] nums, int target, boolean isFindingLeft) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                index = middle;
                if (isFindingLeft) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return index;
    }

    /**
     * 方法一：暴力循环
     * Time： O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 从左到中依次遍历每一个数组元素，记录第一个和最后一个目标值的索引
     */
    public int[] searchRange_2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                    result[1] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }
}
