package q0;

/**
 * 4. 寻找两个正序数组的中位数
 * Median of Two Sorted Arrays
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class L4_FindMedianSortedArrays {
    /**
     * 方法一：遍历全部数组
     * TC: O(n)
     * SC: O(n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) return len2 % 2 == 0 ? (nums2[len2 / 2] + nums2[len2 / 2 - 1]) * 0.5 : nums2[len2 / 2];
        if (len2 == 0) return len1 % 2 == 0 ? (nums1[len1 / 2] + nums1[len1 / 2 - 1]) * 0.5 : nums1[len1 / 2];

        int len = len1 + len2;
        int[] nums = new int[len];
        int i1 = 0;
        int i2 = 0;
        for (int n = 0; n < len; n++) {
            if (i1 == len1) {
                while (i2 < len2) nums[n++] = nums2[i2++];
                break;
            }
            if (i2 == len2) {
                while (i1 < len1) nums[n++] = nums1[i1++];
                break;
            }
            nums[n] = (nums1[i1] <= nums2[i2]) ? nums1[i1++] : nums2[i2++];
        }

        return len % 2 == 0 ? (nums[len / 2] + nums[len / 2 - 1]) * 0.5 : nums[len / 2];
    }

    /**
     * 方法二：遍历一半数组
     * TC: O(n)
     * SC: O(n)
     */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int i1 = 0;
        int i2 = 0;
        int prev = 0;
        int median =  0;
        for (int n = 0; n < len / 2 + 1; n++) {
            prev = median;
            if (i1 < len1 && (i2 >= len2 || nums1[i1] < nums2[i2])) {
                median = nums1[i1++];
            } else {
                median = nums2[i2++];
            }
        }
        if (len % 2 == 0) return (prev + median) * 0.5;

        return median;
    }
}
