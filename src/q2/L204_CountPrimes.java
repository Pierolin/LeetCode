package q2;

import java.util.Arrays;

/**
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 */
public class L204_CountPrimes {

    /**
     * 方法一：埃氏筛法
     * Time:
     * Space:
     * 解题思路：
     * 1. 埃氏筛法：要得到自然数n以内的全部素数，必须把不大于的所有素数的倍数剔除，剩下的就是素数。
     */
    public int countPrimes_2(int n) {
        if (n < 3) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 1;
        for (int i = 3; i * i < n; i += 2) {
            if (isPrime[i]) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i; j * i < n; j++) {
                        isPrime[i * j] = false;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 方法三：暴力循环
     * Time: O((n/2)^2)
     * Space: O(1)
     * 解题思路：
     * 1. 除了 2 外，其它质数都是奇数，只需判断奇数是否是质数即可;
     * 2. 如果不能被小于等于 X 的平方根整除，该数即为质数。
     */
    public int countPrimes_3(int n) {
        if (n < 3) return 0;

        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int x) {
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

}
