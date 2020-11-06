/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class L208_Trie {
    private boolean isEnd;
    private L208_Trie[] next;

    public L208_Trie() {
        isEnd = false;
        next = new L208_Trie[26];
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        L208_Trie node = this;
        for (char c : word.toCharArray()) {
            int n = c - 'a';
            if (node.next[n] == null) node.next[n] = new L208_Trie();
            node = node.next[n];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        L208_Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startWith(String prefix) {
        L208_Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    public L208_Trie searchPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) return null;
        L208_Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
