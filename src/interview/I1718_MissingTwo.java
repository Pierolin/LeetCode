package interview;

import java.util.Arrays;

/**
 * 面试题 17.19. Missing Two LCCI
 * Missing Two LCCI
 * https://leetcode.cn/problems/missing-two-lcci/
 */
public class I1718_MissingTwo {
    /**
     * 方法三：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public int[] missingTwo_3(int[] nums) {
        System.out.println(new String(Arrays.toString(nums)));
        int xor = 0, n = nums.length + 2;
        for (int num : nums) {
            System.out.print(Integer.toBinaryString(xor));
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(Integer.toBinaryString(xor));
            xor ^= i;
        }
        int lowbit = xor & -xor;
        int cur = 0;
        for (int num : nums) {
            if ((num & lowbit) > 0) {
                cur ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) > 0) {
                cur ^= i;
            }
        }
        return new int[]{cur, xor ^ cur};
    }

    /**
     * 方法二：数学法
     * TC: O(n)
     * SC: O(1)
     */
    public int[] missingTwo_2(int[] nums) {
        int n = nums.length + 2;
        int mustSum = (n + 1) * n >> 1;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        int diff = mustSum - actualSum;
        int mid = diff >> 1;
        int midMustSum = (mid + 1) * mid >> 1;
        int midActualSum = 0;
        for (int num : nums) {
            if (num <= mid) midActualSum += num;
        }
        int one = midMustSum - midActualSum;
        int two = diff - one;
        return new int[]{one, two};
    }

    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int[] missingTwo_1(int[] nums) {
        int n = nums.length + 2;
        boolean[] arr = new boolean[n];
        for (int num : nums) arr[num - 1] = true;
        int[] missing = new int[2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!arr[i]) missing[j++] = i + 1;
            if (j == 2) break;
        }
        return missing;
    }

    public static void main(String[] args) {
        I1718_MissingTwo mt = new I1718_MissingTwo();
        mt.missingTwo_3(new int[]{1, 3, 5});
    }
}
