package q13;

import java.util.Arrays;

public class L1385_FindTheDistanceValue {
    /**
     * 方法二：二分查找
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int findTheDistanceValue_2(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        for (int num : arr1) {
            int low = num - d;
            int high = num + d;
            if (!binarySearch(arr2, low, high)) count++;
        }
        return count;

    }

    private boolean binarySearch(int[] nums, int low, int high) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num >= low && num <= high) {
                return true;
            } else if (num < low) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        return false;
    }


    /**
     * 方法一：暴力枚举
     * TC: O(n^2)
     * SC: O(1)
     */
    public int findTheDistanceValue_1(int[] arr1, int[] arr2, int d) {
        int count = 0;
        outer:
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) continue outer;
            }
            count++;
        }
        return count;
    }
}
