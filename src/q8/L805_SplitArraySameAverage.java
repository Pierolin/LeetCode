package q8;

import java.util.HashSet;
import java.util.Set;

/**
 * 805. 数组的均值分割
 * Split Array With Same Average
 * https://leetcode.cn/problems/split-array-with-same-average/description/
 */
public class L805_SplitArraySameAverage {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < n; i++) nums[i] = nums[i] * n - sum;

        int m = n >> 1;
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 1; i < 1 << m; i++) {
            int iSum = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) iSum += nums[j];
            }
            if (iSum == 0 || leftSet.contains(-iSum)) return true;
            leftSet.add(iSum);
        }

        for (int i = 1; i < 1 << (n - m); i++) {
            int iSum = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) iSum += nums[j];
            }
            if (iSum == 0 || (i != (1 << (n - m) - 1) && leftSet.contains(-iSum))) return true;
        }

        return false;
    }
}
