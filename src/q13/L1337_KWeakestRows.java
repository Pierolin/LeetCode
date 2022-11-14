package q13;

import java.util.Arrays;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * The K Weakest Rows in a Matrix
 * https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/description/
 */
public class L1337_KWeakestRows {
    /**
     * 方法一：二分查找
     * TC: O(mnlogn)
     * SC: O(m)
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int n = mat.length;
        int[][] stat = new int[n][2];
        for (int i = 0; i < n; i++) {
            stat[i] = new int[]{i, binarySearch(mat[i])};
        }
        Arrays.sort(stat, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            ans[i] = stat[i][0];
        }
        return ans;
    }

    private int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
