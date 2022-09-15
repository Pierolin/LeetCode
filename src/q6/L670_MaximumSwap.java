package q6;

/**
 * 670. 最大交换
 * Maximum Swap
 * https://leetcode.cn/problems/maximum-swap/
 */
public class L670_MaximumSwap {
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 方法一：暴力枚举
     * TC: O(n^2)
     * SC: O(n)
     */
    public int maximumSwap_1(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int max = num;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(digits, i, j);
                max = Math.max(max, Integer.parseInt(String.valueOf(digits)));
                swap(digits, j, i);
            }
        }
        return max;
    }


    /**
     * 方法二：模拟
     * TC:
     * SC: O(n)
     */
    public int maximumSwap_2(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int start = 0;
        while (start < n - 1) {
            char max = 0;
            int lastMaxIndex = 0;
            for (int i = start; i < n; i++) {
                if (digits[i] >= max) {
                    max = digits[i];
                    lastMaxIndex = i;
                }
            }

            for (int i = start; i < lastMaxIndex; i++) {
                if (digits[i] < max) {
                    swap(digits, i, lastMaxIndex);
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
            start = lastMaxIndex + 1;
        }
        return num;
    }

    /**
     * 方法三：
     * TC: O(n)
     * SC: O(n)
     */
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] maxIndexs = new int[n];
        int maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) maxIndex = i;
            maxIndexs[i] = maxIndex;
        }
        for (int i = 0; i < n; i++) {
            if (digits[i] < digits[maxIndexs[i]]) {
                swap(digits, i, maxIndexs[i]);
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        return num;
    }

    /**
     * 方法三：
     * TC: O(n)
     * SC: O(1)
     */
    public int maximumSwap_4(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int maxIndex = n - 1;
        int swapIndexA = -1;
        int swapIndexB = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
            } else if (digits[i] < digits[maxIndex]) {
                swapIndexA = i;
                swapIndexB = maxIndex;
            }
        }
        if (swapIndexA > -1) {
            swap(digits, swapIndexA, swapIndexB);
            return Integer.parseInt(String.valueOf(digits));
        }
        return num;
    }


}
