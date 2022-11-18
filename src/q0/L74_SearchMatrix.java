package q0;

/**
 * 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class L74_SearchMatrix {
    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(n)
     * 解题思路：
     * 1. 把二维数组转为一维数组求中间元素
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int r = mid / cols;
            int c = mid % cols;
            int num = matrix[r][c];
            if (num == target) return true;
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 方法二：暴力循环
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 从头到尾一个个比较
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == target) return true;
            }
        }
        return false;
    }
}
