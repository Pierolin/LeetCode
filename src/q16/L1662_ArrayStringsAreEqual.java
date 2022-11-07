package q16;

import java.util.Arrays;

/**
 * 1662. 检查两个字符串数组是否相等
 * Check If Two String Arrays are Equivalent
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 */
public class L1662_ArrayStringsAreEqual {
    /**
     * 方法二：字符逐个遍历比对
     * TC: O(n)
     * SC: O(1)
     */
    public boolean arrayStringsAreEqual_3(String[] word1, String[] word2) {
        int w1 = 0;
        int w2 = 0;
        int i1 = 0;
        int i2 = 0;
        int n1 = word1.length;
        int n2 = word2.length;
        while (w1 < n1 && w2 < n2) {
            if (word1[w1].charAt(i1++) != word2[w2].charAt(i2++)) return false;
            if (i1 == word1[w1].length()) {
                i1 = 0;
                w1++;
            }
            if (i2 == word2[w2].length()) {
                i2 = 0;
                w2++;
            }
        }
        return w1 == n1 && w2 == n2;
    }

    /**
     * 方法二：一行代码
     * TC: O(n)
     * SC: O(n)
     */
    public boolean arrayStringsAreEqual_2(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    /**
     * 方法一：拼接字符串进行对比
     * TC: O(n)
     * SC: O(n)
     */
    public boolean arrayStringAreEqual_1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String w : word1) sb1.append(w);
        for (String w : word2) sb2.append(w);
        return sb1.toString().equals(sb2.toString());
    }
}
