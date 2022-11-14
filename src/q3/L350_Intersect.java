package q3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * Intersection of Two Arrays II
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/
 */
public class L350_Intersect {
    /**
     * 方法二：排序 + 双指针
     * TC: O(nlogn)
     * SC: O(nlogn)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int n = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[Math.min(n1, n2)];
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                ans[n] = nums1[i];
                i++;
                j++;
                n++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(ans, 0, n);
    }


    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public int[] intersect_1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int n = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                ans[n++] = num;
                map.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(ans, 0, n);
    }
}
