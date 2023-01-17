package q18;

import java.util.Arrays;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * Check if All the Integers in a Range Are Covered
 * https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered/description/
 */
public class L1893_IsCovered {

    /**
     * 方法一：数组暴力标计法
     * TC: O(
     * SC:
     */
    public boolean isCovered_1(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[right - left + 1];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (i >= left && i <= right) covered[i - left] = true;
            }
        }

        for (int i = 0; i <= right - left; i++) {
            if (!covered[i]) return false;
        }
        return true;
    }

    /**
     * 方法二：模拟检查法
     * TC: O(nm) n 为 ranges 数组大小 , m 为 right - left + 1
     * SC: O(1)
     */
    public boolean isCovered_2(int[][] ranges, int left, int right) {
        outer:
        for (int i = left; i <= right; i++) {
            for (int[] range : ranges) {
                if (i >= range[0] && i <= range[1]) continue outer;
            }
            return false;
        }
        return true;
    }

    /**
     * 方法三：排序法
     * TC: O(nlogn)
     * SC: O(1)
     */
    public boolean isCovered_3(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int[] range : ranges) {
            if (left >= range[0] && left <= range[1]) left = range[1] + 1;
        }
        return left > right;
    }

    /**
     * 方法四： 位运算法
     * TC:
     * SC:
     */
    public boolean isCovered_4(int[][] ranges, int left, int right) {
        return false;
    }

    /**
     * 方法五： 位图法
     * TC:
     * SC:
     */
    public boolean isCovered_5(int[][] ranges, int left, int right) {
        return false;
    }

    /**
     * 方法六： 树状数组法
     * TC:
     * SC:
     */
    public boolean isCovered_6(int[][] ranges, int left, int right) {
        return false;
    }

    /**
     * 方法七： 线段树法
     * TC:
     * SC:
     */
    public boolean isCovered_7(int[][] ranges, int left, int right) {
        return false;
    }

    /**
     * 方法八：差分数组
     * TC:
     * SC:
     */
    public boolean isCovered_8(int[][] ranges, int left, int right) {
        return false;
    }

    /**
     * 方法九：前缀和法
     * TC:
     * SC:
     */
    public boolean isCovered_9(int[][] ranges, int left, int right) {
        return false;
    }
}
