package q6;

/**
 * 667. 优美的排列 II
 * Beautiful Arrangement II
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
public class L667_ConstructArray {

    /**
     * 方法三： 从特殊情况到一般情况
     * TC: O(n)
     * SC: O(n)
     */
    public int[] constructArray_3(int n, int k) {
        int[] arr = new int[n];
        int diff = k;
        arr[0] = 1;
        int i = 1;
        while (i <= k) {
            arr[i] = (i % 2 == 1 ? arr[i - 1] + diff : arr[i - 1] - diff);
            i++;
            diff--;
        }
        while (i < n) arr[i++] = i;
        return arr;
    }

    /**
     * 方法二： 从一般情况到特殊情况
     * TC: O(n)
     * SC: O(n)
     */
    public int[] constructArray_2(int n, int k) {
        int[] arr = new int[n];
        int i = 0;
        while (i < n - k) arr[i++] = i;
        int left = i + 1;
        int right = n;
        while (i < n) {
            arr[i++] = right--;
            if (i < n) arr[i++] = left++;
        }
        return arr;
    }

    /**
     * 方法一： 从特殊情况到一般情况
     * TC: O(n)
     * SC: O(n)
     */
    public int[] constructArray_1(int n, int k) {
        int[] arr = new int[n];
        int left = 1;
        int right = n;
        int i = 0;
        for (int j = 0; j < k; j++) {
            arr[i++] = (j % 2 == 0 ? left++ : right--);
        }
        if (k % 2 == 1) {
            while (i < n) arr[i++] = left++;
        } else {
            while (i < n) arr[i++] = right--;
        }

        return arr;
    }
}
