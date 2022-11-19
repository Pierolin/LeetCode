package q1;

/**
 * 167. 两数之和 II - 输入有序数组
 * Two Sum II - Input Array Is Sorted
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class L167_TwoSum {
    /**
     * 方法二：双指针
     * TC: O(n)
     * SC:  O(1)
     */
    public int[] twoSum_2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }

    /**
     * 方法一：二分查找
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            int j = binarySearch(numbers, i + 1, n - 1, num2);
            if (j > -1) return new int[]{i + 1, j + 1};
        }
        return new int[2];
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num == target) return mid;
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
