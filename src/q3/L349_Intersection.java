package q3;

import java.util.*;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class L349_Intersection {
    /**
     * 方法二：二分查找 + Hash
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 对数组进行排序以便于二分查找
     * 2. 使用哈希表查重。
     */
    public int[] intersection_1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i > 0 && nums2[i] == nums2[i - 1]) continue;
            if (!set.contains(nums2[i]) && isExist(nums2[i], nums1)) {
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    private boolean isExist(int num, int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == num) {
                return true;
            } else if (nums[m] < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    /**
     * 方法二：暴力循环 + Hash
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 使用哈希表判重
     */
    public int[] intersection_2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num2 : nums2) {
            for (int num1 : nums1) {
                if (num1 == num2 && !set.contains(num2)) set.add(num2);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) result[i++] = num;
        return result;

    }
}
