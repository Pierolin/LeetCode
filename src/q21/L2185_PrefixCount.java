package q21;

/**
 * 2185. 统计包含给定前缀的字符串
 * Counting Words With a Given Prefix
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/description/
 */
public class L2185_PrefixCount {
    /**
     * 方法一：模拟 + API
     * TC: O(mn)
     * SC: O(1)
     */
    public int prefixCount_1(String[] words, String pref) {
        int count = 0;
        int n = pref.length();
        for (String word : words) {
            /** 方法一：startsWith
             if (word.startsWith(prefix)) count++;
             */

            /** 方法二：indexOf
             if (word.indexOf(prefix) == 0) count++;
             */

            /** 方法三： equals*/
            if (word.length() >= n && pref.equals(word.substring(0, n))) count++;

        }
        return count;
    }

    /**
     * 方法二：字典树
     * TC:
     * SC:
     */
    public int prefixCount_3(String[] words, String pref) {
        Trie root = new Trie();

        /*
        方法一：性能较差
        for (String word : words) insert(root, word);
        TrieNode prefNode = search(root, pref);
        return prefNode == null ? 0 : prefNode.count;
        */

        /* 方法二：性能较好 */
        insert(root, pref);
        int count = 0;
        for (String word : words) {
            if (search(root, word).isEnd) count++;
        }
        return count;
    }

    private void insert(Trie root, String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new Trie();
            node = node.children[i];
            node.count = node.count + 1;
        }
        node.isEnd = true;
    }

    private Trie search(Trie root, String pref) {
        Trie node = root;
        for (char c : pref.toCharArray()) {
            int i = c - 'a';
            // 方法一
            // if (node.children[i] == null) return null;
            // 方法二：
            if (node.children[i] == null) break;
            node = node.children[i];
        }
        return node;
    }

    class Trie {
        Trie[] children;
        int count;
        boolean isEnd;

        Trie() {
            children = new Trie[26];
            count = 0;
            isEnd = false;
        }
    }
}
