package q16;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 * Mean of Array After Removing Some Elements
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */
public class L1619_TrimMean {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int count = n / 20;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = count; i < n - count; i++) sum += arr[i];
        return sum * 1.0 / (n - count * 2);
    }
}
