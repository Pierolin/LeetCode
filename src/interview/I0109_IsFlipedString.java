package interview;

/**
 * 面试题 01.09. 字符串轮转
 * String Rotation LCCI
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
public class I0109_IsFlipedString {

    /**
     * 方法二：搜索子字符串
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isFlipedString_2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).indexOf(s2) > -1;
    }

    /**
     * 方法一：暴力枚举模拟
     * TC: O(n^2)
     * SC: O(1)
     */
    public boolean isFlipedString_1(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        if (n == 0) return true;
        int start = 0;
        outer:
        while (true) {
            int diff = s2.indexOf(s1.charAt(0), start);
            if (diff == -1) return false;
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt((i + diff) % n)) {
                    start = diff + 1;
                    continue outer;
                }
            }
            return true;
        }
    }
}
