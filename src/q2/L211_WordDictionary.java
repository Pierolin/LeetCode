package q2;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * Design Add and Search Words Data Structure
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/description/
 */
public class L211_WordDictionary {
    L211_WordDictionary[] children;
    boolean isWord;

    public L211_WordDictionary() {
        children = new L211_WordDictionary[26];
        isWord = false;
    }

    public void addWord(String word) {
        L211_WordDictionary node = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new L211_WordDictionary();
            node = node.children[i];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return dfs(this, word);
    }

    private boolean dfs(L211_WordDictionary node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (L211_WordDictionary child : node.children) {
                    if (child != null && dfs(child, word.substring(i + 1))) return true;
                }
                return false;
            } else {
                int j = c - 'a';
                if (node.children[j] == null) return false;
                node = node.children[j];
            }
        }
        return node.isWord;
    }
}
