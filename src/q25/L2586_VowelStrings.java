package q25;

/**
 * 6315. 统计范围内的元音字符串数
 * Count the Number of Vowel Strings in Range
 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range
 */
public class L2586_VowelStrings {
    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(1)
     */
    public int vowelStrings_1(String[] words, int left, int right) {
        int num = 0;
        boolean[] vowels = new boolean[26];
        for (char c : "aeiou".toCharArray()) vowels[c - 'a'] = true;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (vowels[w.charAt(0) - 'a'] && vowels[w.charAt(w.length() - 1) - 'a']) num++;
        }
        return num;
    }

    /**
     * 方法一：正则表达式
     * TC: O(n)
     * SC: O(1)
     */
    public int vowelStrings_12(String[] words, int left, int right) {
        int num = 0;
        for (int i = left; i <= right; i++) {
            if (words[i].matches("[aieou](.*[aieou])?")) num++;
        }
        return num;
    }
}
