package q23;

import java.util.HashSet;
import java.util.Set;

/**
 * 2341. 数组能形成多少数对
 * Maximum Number of Pairs in Array
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class L2341_NumberOfPairs {
    /**
     * 方法一：数组统计
     * TC: O(n)
     * SC: O(1)
     */
    public int[] numberOfPairs_1(int[] nums) {
        int pairs = 0;
        int[] counts = new int[101];
        for (int i : nums) counts[i]++;
        for (int c : counts) pairs += c / 2;
        return new int[]{pairs, nums.length - pairs * 2};
    }

    /**
     * 方法二：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public int[] numberOfPairs_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int lefts = set.size();
        return new int[]{(nums.length - lefts) / 2, lefts};
    }
}
