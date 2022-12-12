package q17;

import java.util.Arrays;

public class L1755_MinOperations {
    /**
     * 方法一：贪心 + 记数排序
     * TC: O(n)
     * SC: O(n)
     */
    public int minOperations_2(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int diff = sum2 - sum1;
        if (diff == 0) return 0;
        if (diff < 0) return minOperations_2(nums2, nums1);
        int[] changes = new int[6];
        for (int num : nums1) changes[6 - num]++;
        for (int num : nums2) changes[num - 1]++;
        int min = 0;
        for (int i = 5; i > 0; i--) {
            int j = changes[i];
            while (j-- > 0) {
                diff -= i;
                min++;
                if (diff <= 0) return min;
            }
        }
        return -1;
    }

    /**
     * 方法一：贪心 + 排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int minOperations_1(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int diff = sum2 - sum1;
        if (diff == 0) return 0;
        if (diff < 0) return minOperations_1(nums2, nums1);
        int n = nums1.length + nums2.length;
        int[] changes = new int[n];
        int i = 0;
        for (int num : nums1) changes[i++] = 6 - num;
        for (int num : nums2) changes[i++] = num - 1;
        Arrays.sort(changes);
        for (int j = n - 1; j >= 0; j--) {
            diff -= changes[j];
            if (diff <= 0) return n - j;
        }
        return -1;
    }
}
