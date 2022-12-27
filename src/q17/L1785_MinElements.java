package q17;

import java.util.Arrays;

/**
 * 1785. 构成特定和需要添加的最少元素
 * Minimum Elements to Add to Form a Given Sum
 * https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/description/
 */
public class L1785_MinElements {
    /**
     * 方法一：贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        long diff = Math.abs(goal - sum);
        int min = (int) diff / limit;
        if (diff % limit > 0) min++;
        return min;
    }
}
