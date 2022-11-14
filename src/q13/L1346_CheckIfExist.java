package q13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L1346_CheckIfExist {
    /**
     * 方法二：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public boolean checkIfExist_2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (num == 0 && set.contains(0)) return true;
            set.add(num);
        }
        for (int num : arr) {
            if (num != 0 && set.contains(num * 2)) return true;
        }
        return false;
    }
    /**
     * 方法一：二分查找
     * TC: O(nlogn)
     * SC: O(1)
     */
    public boolean checkIfExist_1(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int target = arr[i] * 2;
            int left = i + 1;
            int right = n - 1;
            if (target < 0) {
                left = 0;
                right = i - 1;
            }
            if (binarySearch(arr, left, right, target)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num == target) return true;
            if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
