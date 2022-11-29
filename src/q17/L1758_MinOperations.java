package q17;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * Minimum Changes To Make Alternating Binary String
 * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/description/
 */
public class L1758_MinOperations {
    /**
     * 方法一：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_2(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count += (s.charAt(i) - '0') ^ (i & 1);
        }
        return Math.min(count, n - count);
    }

    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int minOperations_1(String s) {
        return Math.min(countChanges(s, '0'), countChanges(s, '1'));
    }

    private int countChanges(String s, char first) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c != first) count++;
            first = first == '0' ? '1' : '0';
        }
        return count;
    }
}
