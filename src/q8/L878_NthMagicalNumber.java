package q8;

/**
 * 878. 第 N 个神奇数字
 * Nth Magical Number
 * https://leetcode.cn/problems/nth-magical-number/description/
 */
public class L878_NthMagicalNumber {
    private final int MOD = (int) (1e9 + 7);

    /**
     * 方法二：二分查找 + 容斥原理
     * TC: O(log(min(a,b)*n)))
     * SC: O(1)
     */
    public int nthMaticalNumber_2(int n, int a, int b) {
        if (b > a) return nthMaticalNumber_2(n, b, a);
        long left = a;
        long right = left * n;
        long c = lcm(a, b);
        while (left <= right) {
            long mid = (left + right) >> 1;
            long count = mid / a + mid / b + mid / c;
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return (int) (left % MOD);
    }

    /**
     * 最小公倍数 = 两数乘积 / 最大公约数
     */
    private long lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * 求最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 方法一：暴力枚举 (超时)
     * TC: O(n)
     * SC: O(1)
     */
    public int nthMagicalNumber_1(int n, int a, int b) {
        if (b > a) return nthMagicalNumber_1(n, b, a);
        long i = 1;
        long j = 1;
        long nth = 0;
        long ai = 0;
        long bj = 0;
        while (nth < n) {
            nth++;
            ai = a * i % MOD;
            bj = b * j % MOD;
            if (ai < bj) {
                i++;
            } else if (ai == bj) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return (int) Math.min(ai, bj) % MOD;
    }
}
