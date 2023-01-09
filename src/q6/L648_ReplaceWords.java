package q6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 648. 单词替换
 * Replace Words
 * https://leetcode.cn/problems/replace-words/description/
 */
public class L648_ReplaceWords {

    /**
     * 方法一：模拟
     * TC: O(d+∑wi2)。其中  是 dictionary 的字符数，构建哈希集合消耗 O(d) 时间。wi 是 sentence 分割后第 i 个单词的字符数，判断单词的前缀子字符串是否位于哈希集合中消耗 O(wi2) 时间。
     * SC: O(d+s)，其中 s 是 sentence 的字符数。构建哈希集合消耗 O(d) 空间，分割 sentence消耗 O(s) 空间
     */
    public String replaceWords_1(List<String> dictionary, String sentence) {
        dictionary.sort((a, b) -> a.length() - b.length());
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String root : dictionary) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    /**
     * 方法二：哈希表
     * TC: O(d+∑wi2)。其中 d 是 dictionary 的字符数，构建哈希集合消耗 O(d) 时间。wi 是 sentence 分割后第 i 个单词的字符数，判断单词的前缀子字符串是否位于哈希集合中消耗 O(wi2) 时间。
     * SC: O(d+s)，其中 s 是 sentence 的字符数。构建哈希集合消耗 O(d) 空间，分割 sentence消耗 O(s) 空间
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String root : dictionary) set.add(root);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j <= word.length(); j++) {
                String pref = word.substring(0, j);
                if (set.contains(pref)) {
                    words[i] = pref;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    /**
     * 方法三：字典树
     * TC: O(d+s) 其中 d 是 dictionary 的字符数，s 是 sentence 的字符数。构建字典树消耗 O(d) 时间，每个单词搜索前缀均消耗线性时间。
     * SC: O(d+s) 构建哈希集合消耗 O(d) 空间，分割 sentence 消耗 O(s) 空间。
     */
    Trie root;

    public String replaceWords_2(List<String> dictionary, String sentence) {
        root = new Trie();
        StringBuilder sb = new StringBuilder();
        for (String dic : dictionary) insert(dic);
        for (String word : sentence.split(" ")) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(search(word));
        }
        return sb.toString();
    }

    private void insert(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new Trie();
            node = node.children[i];
        }
        node.isRoot = true;
    }

    private String search(String word) {
        Trie node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            int i = c - 'a';
            if (node.children[i] == null) return word;
            if (node.children[i].isRoot) return sb.toString();
            node = node.children[i];
        }
        return word;
    }

    class Trie {
        Trie[] children;
        boolean isRoot;

        public Trie() {
            children = new Trie[26];
            isRoot = false;
        }
    }
}
