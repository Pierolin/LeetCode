package q20;

/**
 * 2027. 转换字符串的最少操作次数
 * Minimum Moves to Convert String
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/description/
 */
public class L2027_MinimumMoves {
    /**
     * 方法一：模拟法
     * TC: O(n）
     * SC: O(1)
     */
    public int minimumMoves(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 2;
            }
        }
        return count;
    }
}
