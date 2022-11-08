package q16;

/**
 * 1684. 统计一致字符串的数目
 * Count the Number of Consistent Strings
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/description/
 */
public class L1684_CountConsistentStrings {
    /**
     * 方法一：位运算
     * TC: O(n+∑mi) 其中 n 是字符串 allowed 的长度，mi 是字符串 words[i] 的长度。
     * SC: O(1)
     */
    public int countConsistentStrings_2(String allowed, String[] words) {
        int count = 0;
        int mask = 0;

        for (char c : allowed.toCharArray()) {
            mask |= 1 << (c - 'a');
        }

        outer:
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if ((mask | 1 << (c - 'a')) != mask) continue outer;
            }
            count++;
        }

        return count;
    }

    /**
     * 方法一：数组哈希
     * TC: O(n+∑mi) 其中 n 是字符串 allowed 的长度，mi 是字符串 words[i] 的长度。
     * SC: O(C) C 为 26
     */
    public int countConsistentStrings_1(String allowed, String[] words) {
        int count = 0;
        boolean[] dict = new boolean[26];
        for (char c : allowed.toCharArray()) {
            dict[c - 'a'] = true;
        }

        outer:
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (!dict[c - 'a']) continue outer;
            }
            count++;
        }
        return count;
    }
}
