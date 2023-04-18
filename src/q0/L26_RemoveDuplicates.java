package q0;

/**
 * 26. 删除有序数组中的重复项
 * Remove Duplicates from Sorted Array
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class L26_RemoveDuplicates {
    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j] && i > j) nums[++j] = nums[i];
        }
        return j + 1;
    }
}
