package q14;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class L1455_IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = -1;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(searchWord) == 0) return i + 1;
        }
        return index;
    }
}
