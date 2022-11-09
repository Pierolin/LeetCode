package q0;

/**
 * 69. x 的平方根
 * Sqrt(x)
 * https://leetcode.cn/problems/sqrtx/description/
 */
public class L69_MySqrt {
    /**
     * 方法一：牛顿迭代法
     * TC: O(1)
     * SC: O(1)
     * 背景知识参考：https://haokan.baidu.com/v?pd=wisenatural&vid=3716016261903683866
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double x0 = getStartNum(x);
        double xi = 0;
        while (true) {
            xi = (x0 + x / x0) * 0.5;
            double diff = xi - x0;
            if (diff < 0) diff = -diff;
            if (diff < 1e-7) break;
            x0 = xi;
        }
        return (int) xi;
    }

    private int getStartNum(int x) {
        int num = 1;
        int half = countDigits(x) / 2;
        while (--half > 0) num *= 10;
        return num;
    }

    private int countDigits(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int mySqrt_1(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int square = mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
