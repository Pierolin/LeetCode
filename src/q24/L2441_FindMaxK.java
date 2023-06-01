package q24;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. 与对应负数同时存在的最大正整数
 * Largest Positive Integer That Exists With Its Negative
 * https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative
 */
public class L2441_FindMaxK {
    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(-x)) max = Math.max(max, Math.abs(x));
            set.add(x);
        }
        return max;
    }
}
