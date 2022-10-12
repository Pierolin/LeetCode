package q17;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * Check if One String Swap Can Make Strings Equal
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class L1790_AreAlmostEqual {

    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(n)
     */
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            char c = chars1[i];
            if (c != chars2[i]) {
                int j = i;
                while (true) {
                    j = s2.indexOf(c, j + 1);
                    if (j == -1) return false;
                    chars1[i] = chars1[j];
                    chars1[j] = c;
                    if (String.valueOf(chars1).equals(s2)) return true;
                    chars1[j] = chars1[i];
                    chars1[i] = c;
                }
            }
        }

        return true;
    }
}
