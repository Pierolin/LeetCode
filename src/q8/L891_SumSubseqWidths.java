package q8;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 * Sum of Subsequence Widths
 * https://leetcode.cn/problems/sum-of-subsequence-widths/description/
 */
public class L891_SumSubseqWidths {

    private static final int MOD = (int) 1e9 + 7;


    /**
     * 方法一：元素贡献值
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int sumSubseqWidths_2(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        int n = nums.length;
        long pow2 = 1;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] - nums[n - i - 1]) * pow2;
            pow2 = pow2 * 2 % MOD;
        }
        return (int) (sum % MOD + MOD) % MOD;
    }

    /**
     * 方法一：元素贡献值
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int sumSubseqWidths_1(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += (pow(2, i) - pow(2, n - i - 1)) * nums[i];
        }
        return (int) (sum % MOD + MOD) % MOD;
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }
}
