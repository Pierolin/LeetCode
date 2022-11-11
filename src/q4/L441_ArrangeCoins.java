package q4;

/**
 * 441. 排列硬币
 * Arranging Coins
 * https://leetcode.cn/problems/arranging-coins/
 */
public class L441_ArrangeCoins {

    /**
     * 方法四：数学法
     * TC: O(1)
     * SC: O(1)
     */
    public int arrangeCoins_4(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }

    /**
     * 方法三：二分查询
     * TC: O(logn)
     * SC: O(1)
     */
    public int arrangeCoins_3(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long sum = (long) (1 + mid) * mid / 2;
            if (sum == n) {
                return mid;
            } else if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    /**
     * 方法二：暴力循环
     * TC: O(n)
     * SC: O(1)
     */
    public int arrangeCoins_2(int n) {
        int i = 0;
        while (n - i > 0) n -= ++i;
        return i;
    }

    /**
     * 方法一：暴力循环
     * TC: O(n)
     * SC: O(1)
     */
    public int arrangeCoins_1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum == n) return i;
            if (sum > n) return i - 1;
        }
        return 0;
    }
}
