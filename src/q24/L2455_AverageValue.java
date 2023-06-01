package q24;

import java.util.Arrays;

/**
 * 2455. 可被三整除的偶数的平均值
 * Average Value of Even Numbers That Are Divisible by Three
 * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three
 */
public class L2455_AverageValue {
    /**
     * 方法一：遍历法
     * TC: O(n)
     * SC：O(1)
     */
    public int averageValue_1(int[] nums) {
        int n = 0;
        int sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                n++;
                sum += num;
            }
        }
        return n == 0 ? 0 : sum / n;
    }

    /**
     * 方法二：API 法
     * TC: O(n)
     * SC：O(1)
     */
    public int averageValue_2(int[] nums) {
        return (int) Arrays.stream(nums).filter(n -> n % 6 == 0).average().orElse(0D);
    }
}
