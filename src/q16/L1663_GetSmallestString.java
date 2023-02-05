package q16;

import java.util.Arrays;

public class L1663_GetSmallestString {

    /**
     * 方法一：二分查找 + 前缀和
     * TC: O(logn)
     * SC: O(1)
     */
    public String getSmallestString_1(int n, int k){
        StringBuilder sb = new StringBuilder();
        int preSum = 0;
        int count = 0;
        for (int i = 1; i <= 26; i++) {
            int max = binarySearch(i, n - count, k - preSum);
            count += max;
            preSum += max * i;
            sb.append(String.valueOf((char)(i + 'a' - 1)).repeat(max));
        }
        return sb.toString();
    }

    private int binarySearch(int num, int n, int k) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int diff = num * mid + (n - mid) * 26 - k;
            if (diff >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    /**
     * 方法二：贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public String getSmallestString_2(int n, int k){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            sb.append((char)('a' + lower - 1));
        }
        return sb.toString();
    }


    /**
     * 方法三：贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public String getSmallestString_3(int n, int k){
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        int diff = k - n;
        int i = n - 1;
        while (diff >= 25) {
            arr[i--] = 'z';
            diff -= 25;
        }
        if (diff > 0) arr[i] = (char)('a' + diff);
        return String.valueOf(arr);
    }

    /**
     * 方法三：数学法
     * TC: O(n)
     * SC: O(1)
     */
    public String getSmallestString_4(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int diff = k - n;
        int zCount = diff / 25;
        int remain = diff % 25;
        if (zCount == n) {
            sb.append("z".repeat(zCount));
        } else {
            sb.append("a".repeat((n - zCount - 1)));
            sb.append((char)('a' + remain));
            sb.append("z".repeat(zCount));
        }
        return sb.toString();
    }
}
