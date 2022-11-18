package q0;

/**
 * 33. 搜索旋转排序数组
 * Search in Rotated Sorted Array
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 */
public class L33_Search {
    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int num = nums[mid];
            if (num == target) return mid;
            int leftest = nums[left];
            int rightest = nums[right];
            if (leftest <= num) {
                if (target >= leftest && target < num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > num && target <= rightest) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
