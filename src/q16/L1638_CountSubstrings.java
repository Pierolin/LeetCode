package q16;

/**
 * 1638. 统计只差一个字符的子串数目
 * Count Substrings That Differ by One Character
 * https://leetcode.cn/problems/count-substrings-that-differ-by-one-character
 */
public class L1638_CountSubstrings {
    /**
     * 方法一：暴力枚举
     * TC: O(m×n×min(m,n))
     * SC: O(1)
     */
    public int countSubstrings_1(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        int n = Math.min(sn, tn);
        int count = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= sn; i++) {
                String a = s.substring(i, i + len);
                for (int j = 0; j + len <= tn; j++) {
                    String b = t.substring(j, j + len);
                    if (isDiffOne(a, b)) count++;
                }
            }
        }
        return count;
    }

    private boolean isDiffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
