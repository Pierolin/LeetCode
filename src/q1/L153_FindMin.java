package q1;

/**
 * 153. 寻找旋转排序数组中的最小值
 * Find Minimum in Rotated Sorted Array
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class L153_FindMin {

    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int num = nums[mid];
            int leftest = nums[left];
            if (leftest <= num) {
                min = Math.min(min, leftest);
                left = mid + 1;
            } else {
                min = Math.min(min, num);
                right = mid - 1;
            }
        }
        return min;
    }
}
