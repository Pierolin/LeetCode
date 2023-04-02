package q12;

/**
 * 1255. 得分最高的单词集合
 * Maximum Score Words Formed by Letters
 * https://leetcode.cn/problems/maximum-score-words-formed-by-letters
 */
public class L1255_MaxScoreWords {

    /**
     * 方法一：状态压缩 / 位运算枚举
     * TC: O(L+(S+∑)×2^n)，其中 L 是数组 letters 的长度，S 是字符串数组 words 的所有字符串长度，∑=26 是字符集大小。words 中的每个
     *     单词存在于 2^(n−1) 个子集中，因此每个单词被遍历 2^(n-1) 次。
     * SC: O(∑)。保存 arrLetter 和 arrWord 需要 O(∑) 的空间。
     */
    public int maxScoreWords_1(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int max = 0;
        int[] arrLetter = new int[26];

        for (char c : letters) arrLetter[c - 'a']++;

        for (int bit = 1; bit < (1 << n); bit++) {
            int[] arrWord = new int[26];
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) > 0) {
                    for (char c : words[i].toCharArray()) arrWord[c - 'a']++;
                }
            }

            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (arrWord[i] > arrLetter[i]) {
                    sum = 0;
                    break;
                }
                sum += score[i] * arrWord[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * 方法二：回溯法
     * TC: O(m+L2^n)，其中 n 为 words 的长度，L 为 words[i] 的长度，m 为 letters 的长度。搜索树是一棵满二叉树，有 O(2^n) 个节点，
     *     每个节点的耗时为 O(L)，所以回溯的时间复杂度为 O(L2^n)，加上初始化 left 的 O(m) 时间，总的时间复杂度为 O(m+L2^n)。
     * SC: O(∣Σ∣)，其中 ∣Σ∣ 为字符集合的大小，本题中字符均为小写字母，所以 ∣Σ∣=26。
     */
    public int maxScoreWords_2(String[] words, char[] letters, int[] score) {
        int[] leftLetters = new int[26];
        for (char c : letters) leftLetters[c - 'a']++;
        return backTrack(words, leftLetters, score, 0);
    }

    private int backTrack(String[] words, int[] leftLetters, int[] score, int index) {
        if (index == words.length) return 0;
        int[] currLeftLetters = leftLetters.clone();
        int sumSelected = 0;
        for (char c : words[index].toCharArray()) {
            int i = c - 'a';
            if (currLeftLetters[i]-- == 0) return backTrack(words, leftLetters, score, index + 1);
            sumSelected += score[i];
        }
        sumSelected += backTrack(words, currLeftLetters, score, index + 1);
        int sumUnselected = backTrack(words, leftLetters, score, index + 1);
        return Math.max(sumSelected, sumUnselected);
    }
}
