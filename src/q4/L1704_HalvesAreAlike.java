package q4;

import java.util.HashSet;
import java.util.Set;

/**
 * 1704. 判断字符串的两半是否相似
 * Determine if String Halves Are Alike
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/description/
 */
public class L1704_HalvesAreAlike {
    /**
     * 方法二：数组记数模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean halvesAreAlike_2(String s) {
        int[] arr = new int[123];
        for (char c : "aeiouAEIOU".toCharArray()) arr[c] = 1;
        int count = 0;
        char[] chars = s.toCharArray();
        int half = chars.length / 2;
        for (int i = 0; i < half; i++) {
            if (arr[chars[i]] == 1) count++;
            if (arr[chars[i + half]] == 1) count--;
        }
        return count == 0;
    }

    /**
     * 方法一：哈希记数模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
        int count = 0;
        char[] chars = s.toCharArray();
        int half = chars.length / 2;
        for (int i = 0; i < half; i++) {
            if (set.contains(chars[i])) count++;
            if (set.contains(chars[i + half])) count--;
        }
        return count == 0;
    }
}
