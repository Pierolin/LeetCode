package q24;

/**
 * 2413. 最小偶倍数
 * Smallest Even Multiple
 * https://leetcode.cn/problems/smallest-even-multiple
 */
public class L2413_SmallestEvenMultiple {
    /**
     * 方法一：判断奇偶数
     * TC: O(1)
     * SC: O(1)
     */
    public int smallestEvenMultiple_1(int n) {
        return n % 2 == 2 ? n : 2 * n;
    }

    /**
     * 方法二：位运算
     * TC: O(1)
     * SC: O(1)
     */
    public int smallestEvenMultiple_2(int n) {
        return n * ((n & 1) + 1);
    }

    /**
     * 方法三：位运算
     * TC: O(1)
     * SC: O(1)
     */
    public int smallestEvenMultiple_3(int n) {
        return n << (n & 1);
    }
}
