package q6;

/**
 * 633. 平方数之和
 * Sum of Square Numbers
 * https://leetcode.cn/problems/sum-of-square-numbers/description/
 */
public class L633_JudgeSquareSum {

    /**
     * 方法一：二分查找 + 双指针
     * TC: O(n)
     * SC: O(1)
     */
    public boolean judgeSquareSum_2(int c) {
        long left = 0;
        long right = binarySearch(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) return true;
            if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    private long binarySearch(int c) {
        long left = 0;
        long right = c;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long diff = mid * mid - c;
            if (diff == 0) return mid;
            if (diff < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    /**
     * 方法一：使用 API
     * TC: O(n)
     * SC: O(1)
     */
    public boolean judgeSquareSum_1(int c) {
        if (c == 0) return true;
        for (int i = 0; i < Math.sqrt(c); i++) {
            double sqrt = Math.sqrt(c - i * i);
            if ((long) sqrt == sqrt) return true;
        }
        return false;
    }
}
