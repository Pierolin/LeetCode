/**
 * 367. 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class L367_IsPerfectSquare {
    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     * 解题思路：
     * 1. 取中间数 mid 的平方与 num 比较，如果小于 num, 把左指针 left 设为 mid + 1,  如果大于 num, 把右指针 right 设为 mid - 1
     */
    public boolean isPerfectSquare_1(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((double) mid * mid == num) {
                return true;
            } else if ((double) mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    /**
     * 方法二：暴力循环 (超时)
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 从 1 开始递增取平方，直到平方数不小于目标数;
     */
    public boolean isPerfectSquare_2(int num) {
        int i = 1;
        while (i * i < num) i++;
        return i * i == num;
    }
}




