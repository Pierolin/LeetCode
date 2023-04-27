package q10;

/**
 * 1031. 两个非重叠子数组的最大和
 * Maximum Sum of Two Non-Overlapping Subarrays
 */
public class L1031_MaxSumTwoNoOverlap {

    /**
     * 方法一：前缀和
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int maxSumTwoNoOverlap_1(int[] nums, int firstLen, int secondLen) {
        int max = 0;
        int n = nums.length;
        int[] preSums = new int[n + 1];
        for (int i = 0; i < n; i++) preSums[i + 1] = preSums[i] + nums[i];

        for (int i = 0; i <= n - firstLen; i++) {
            int firstSum = preSums[i + firstLen] - preSums[i];
            int secondSum = 0;
            for (int j = 0; j <= i - secondLen; j++)
                secondSum = Math.max(secondSum, preSums[j + secondLen] - preSums[j]);
            for (int j = i + firstLen + 1; j <= n - secondLen; j++)
                secondSum = Math.max(secondSum, preSums[j + secondLen] - preSums[j]);
            max = Math.max(max, firstSum + secondSum);
        }
        return max;
    }

    /**
     * 方法二：前缀和
     * TC: O(n)
     * SC: O(n)
     */
    public int maxSumTwoNoOverlap_2(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSums = new int[n + 1];
        for (int i = 0; i < n; i++) preSums[i + 1] = preSums[i] + nums[i];
        int max = 0;
        int maxFirstSum = 0;
        int maxSecondSum = 0;
        int len = firstLen + secondLen;
        for (int i = len; i <= n; i++) {
            maxFirstSum = Math.max(maxFirstSum, preSums[i - secondLen] - preSums[i - len]);
            maxSecondSum = Math.max(maxSecondSum, preSums[i - firstLen] - preSums[i - len]);
            max = Math.max(max, Math.max((maxFirstSum + preSums[i] - preSums[i - secondLen]), (maxSecondSum + preSums[i] - preSums[i - firstLen])));
        }
        return max;
    }
}
