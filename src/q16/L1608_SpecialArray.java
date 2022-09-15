package q16;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * Special Array With X Elements Greater Than or Equal X
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class L1608_SpecialArray {

    /**
     * 方法一：暴力枚举
     * TC: O(n^2)
     * SC: O(1)
     */
    public int specialArray_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) count++;
            }
            if (count == i) return i;
        }
        return -1;
    }

    /**
     * 方法二：排序 + 一次遍历
     * TC: O(nlogn)
     * SC: O(logn)
     */
    public int specialArray_2(int[] nums) {
        int n = nums.length;
        int x = n;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] < x) {
                x--;
            } else {
                if (i > 0 && nums[i - 1] >= x) return -1;
                return x;
            }
        }
        return -1;
    }

    /**
     * 方法三：排序 + 二分法
     * TC: O(nlogn)
     * SC: O(logn)
     */

    public int specialArray_3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int x = n - mid;
            if (nums[mid] >= x) {
                if (mid == 0 || nums[mid - 1] < x) return x;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 方法四：数组统计
     * TC: O(n)
     * SC: O(n)
     */
    public int specialArray_4(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        int[] counts = new int[max + 1];
        //int[] counts = new int[1001];
        for (int num : nums) counts[num]++;
        int sum = 0;
        for (int i = max; i >= 0; i--) {
            //for (int i = 1000; i >= 0; i--) {
            sum += counts[i];
            if (sum == i) return sum;
            if (sum > i) return -1;
        }
        return -1;
    }
}
