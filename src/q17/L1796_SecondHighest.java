package q17;

/**
 * 1796. 字符串中第二大的数字
 * Second Largest Digit in a String
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/description/
 */
public class L1796_SecondHighest {
    /**
     * 方法四：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public int secondHighest_4(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                mask |= 1 << (c - '0');
            }
        }
        boolean hasSetMax = false;
        for (int i = 9; i >= 0; i--) {
            if (((mask >> i) & 1) == 1) {
                if (hasSetMax) return i;
                hasSetMax = true;
            }
        }
        return -1;
    }


    /**
     * 方法三：数组分桶统计
     * TC: O(n)
     * SC: O(1)
     */
    public int secondHighest_3(String s) {
        boolean[] arr = new boolean[10];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) arr[c - '0'] = true;
        }
        boolean hasSetMax = false;
        for (int i = 9; i >= 0; i--) {
            if (arr[i]) {
                if (hasSetMax) return i;
                hasSetMax = true;
            }
        }
        return -1;
    }

    /**
     * 方法二：一次遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int secondHighest_2(String s) {
        int first = -1;
        int second = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int n = c - '0';
                if (n > first) {
                    second = first;
                    first = n;
                } else if (n < first && n > second) {
                    second = n;
                }
            }
        }
        return second;
    }

    /**
     * 方法一：两次遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int secondHighest_1(String s) {
        int first = -1;
        int second = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) first = Math.max(first, c - '0');
        }
        for (char c : chars) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit < first) second = Math.max(second, digit);
            }
        }
        return second;
    }
}
