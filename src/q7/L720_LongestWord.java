package q7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 * Longest Word in Dictionary
 * https://leetcode.cn/problems/longest-word-in-dictionary/description/
 */
public class L720_LongestWord {
    /**
     * 方法一：排序 + 哈希表
     * TC: O(∑li×logn)，其中 nnn 是数组 words 的长度，li 是单词 words[i] 的长度。对数组 words 排序最多需要 O(∑li×logn) 的时间，排序后遍历数组 words 将单词加入哈希集合并得到答案最多需要 O(∑li) 的时间。由于在渐进意义下 O(∑li)小于 O(∑li×logn)，因此时间复杂度是 O(∑li×logn) \log n)O(∑0≤i<n​li​×logn)
     * SC: O(∑li) li 是单词 words[i] 的长度
     */
    public String longestWord_1(String[] words) {
        String longest = "";
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });

        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                longest = word;
            }
        }
        return longest;
    }

    /**
     * 方法二：字典树
     * TC: O(∑li)，li 是单词 words[i] 的长度
     * SC: O(∑li)
     */
    Trie root = new Trie();
    String longest = "";

    public String longestWord_2(String[] words) {
        for (String word : words) insert(word);
        // 方法一：由于符合要求的单词的每个前缀都是符合要求的单词，因此可以使用字典树存储所有符合要求的单词。
        for (String word : words) {
            if (search(word)) {
                int diff = word.length() - longest.length();
                if (diff > 0) {
                    longest = word;
                } else if (diff == 0) {
                    longest = word.compareTo(longest) < 0 ? word : longest;
                }
            }
        }
        // 方法二：DFS (效率较低)
        //dfs(root, "");
        return longest;
    }

    private void insert(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new Trie();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    private boolean search(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null || !node.children[i].isEnd) return false;
            node = node.children[i];
        }
        return node.isEnd;
    }

    private void dfs(Trie node, String word) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].isEnd) {
                dfs(node.children[i], word + (char) (i + 'a'));
            } else {
                int diff = word.length() - longest.length();
                if (diff > 0) {
                    longest = word;
                } else if (diff == 0) {
                    longest = word.compareTo(longest) < 0 ? word : longest;
                }
            }
        }
    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
}
