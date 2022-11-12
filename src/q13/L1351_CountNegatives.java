package q13;

/**
 * 1351. 统计有序矩阵中的负数
 * Count Negative Numbers in a Sorted Matrix
 * https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 */

public class L1351_CountNegatives {
    /**
     * 方法二：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int countNegatives_2(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        for (int[] row : grid) {
            count += binarySearch(row, n);
        }
        return count;
    }

    private int binarySearch(int[] nums, int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }

    /**
     * 方法一：暴力枚举
     * TC: O(n)
     * SC: O(1);
     */
    public int countNegatives_1(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        for (int[] row : grid) {
            for (int i = 0; i < n; i++) {
                if (row[i] < 0) {
                    count += n - i;
                    break;
                }
            }
        }
        return count;
    }
}
