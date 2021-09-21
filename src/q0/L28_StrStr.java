package q0;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class L28_StrStr {
    /**
     * 方法一：KMP 算法
     * Time: O(m+n)
     * Space: O(1)
     */
    public int strStr_1(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen == 0 ) return 0;
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < hLen; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j)) j++;

            if (j == nLen) return i - nLen + 1;
        }
        return -1;
    }

    /**
     * 生成前缀表
     */
    private int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len];
        int j = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) j = next[j - 1];
            if (needle.charAt(j) == needle.charAt(i)) j++;
            next[i] = j;
        }
        return next;
    }


    /**
     * 方法二：暴力法
     * Time: O(m*n)
     * Space: O(1)
     * 解题思路：
     * 1. 循环原字符串 haystack 和匹配串 needle
     */
    public int strStr_2(String haystack, String needle) {
        if (needle.equals("")) return 0;

        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        for (int i = 0; i < hs.length; i++) {
            if (hs[i] == ns[0]) {
                int start = i;
                for (int j = 0; j < ns.length && i < hs.length; j++) {
                    if (hs[i++] != ns[j]) {
                        i = start;
                        break;
                    }
                    if (j == ns.length - 1) return start;
                }
            }
        }

        return -1;
    }
}
