package q14;

import java.util.*;

/**
 * 1403. 非递增顺序的最小子序列
 * Minimum Subsequence in Non-Increasing Order
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
public class L1403_MinSubsequence {
    /**
     * 方法一： 貪心算法
     * TC: O(nlogn)
     * SC: O(logn)
     */
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            list.add(nums[i]);
            sum += nums[i];
            if (sum > total - sum) break;
        }
        return list;
    }
}
