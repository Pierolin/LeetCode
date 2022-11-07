package q16;

/**
 * 1668. 最大重复子字符串
 * Maximum Repeating Substring
 * https://leetcode.cn/problems/maximum-repeating-substring/description/
 */
public class L1668_MaxRepeating {
    /**
     * 方法五：动态规划
     * TC: O(n * m)
     * SC: O(n)
     */
    public int maxRepeating_5(String sequence, String word) {
        int max = 0;
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        for (int i = m; i <= n; i++) {
            String sub = sequence.substring(i - m, i);
            if (sub.equals(word)) {
                dp[i] = dp[i - m] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 方法四：二分法
     * TC: O(logn * n * m)
     * SC: O(n)
     */
    public int maxRepeating_4(String sequence, String word) {
        int left = 0;
        int right = sequence.length() / word.length();
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mid; i++) {
                sb.append(word);
            }
            if (sequence.contains(sb)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    /**
     * 方法三：逐个字符比较
     * TC: O(n^2 * m)
     * SC: O(n)
     */
    public int maxRepeating_3(String sequence, String word) {
        int lenS = sequence.length();
        int lenW = word.length();
        int max = 0;

        for (int i = 0; i < lenS; i++) {
            int j = 0;
            int count = 0;
            int x = i;
            while (x < lenS && sequence.charAt(x) == word.charAt(j)) {
                x++;
                j++;
                if (j == lenW) {
                    count++;
                    j = 0;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }


    /**
     * 方法二：暴力枚举
     * TC: O(n^2 * m)
     * SC: O(n)
     */
    public int maxRepeating_2(String sequence, String word) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        while (sequence.contains(sb)) {
            max++;
            sb.append(word);
        }
        return max;
    }

    /**
     * 方法一：暴力枚举
     * TC: O(n^2 * m)
     * SC: O(n)
     */
    public int maxRepeating_1(String sequence, String word) {
        int i = 1;
        while (sequence.contains(word.repeat(i))) i++;
        return i - 1;
    }


}
