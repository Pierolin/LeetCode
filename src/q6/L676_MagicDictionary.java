package q6;

/**
 * 方法一：字典树
 */
public class L676_MagicDictionary {
    L676_MagicDictionary[] children;
    boolean isEnd;

    public L676_MagicDictionary() {
        children = new L676_MagicDictionary[26];
        isEnd = false;
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            L676_MagicDictionary node = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) node.children[i] = new L676_MagicDictionary();
                node = node.children[i];
            }
            node.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        // DFS 方法一
        return dfs1(this, searchWord, 0, false);

        // DFS 方法二
        /*
        for (int i = 0; i < searchWord.length(); i++) {
            if (dfs2(this, searchWord, 0, i)) return true;
        }
        return false;
        */
    }

    private boolean dfs1(L676_MagicDictionary node, String searchWord, int i, boolean isChanged) {
        if (i == searchWord.length()) return node.isEnd && isChanged;

        int j = searchWord.charAt(i) - 'a';
        L676_MagicDictionary child = node.children[j];
        if (child != null && dfs1(child, searchWord, i + 1, isChanged)) return true;

        if (!isChanged) {
            for (int x = 0; x < 26; x++) {
                if (x == j) continue;
                child = node.children[x];
                if (child != null && dfs1(child, searchWord, i + 1, true)) return true;
            }
        }

        return false;
    }

    private boolean dfs2(L676_MagicDictionary node, String searchWord, int i, int changedIdx) {
        if (node == null) return false;
        if (i == searchWord.length()) return node.isEnd;
        int x = searchWord.charAt(i) - 'a';
        if (i == changedIdx) {
            for (int j = 0; j < 26; j++) {
                if (j == x) continue;
                L676_MagicDictionary child = node.children[j];
                if (dfs2(child, searchWord, i + 1, changedIdx)) return true;
            }
            return false;
        }
        return dfs2(node.children[x], searchWord, i + 1, changedIdx);
    }
}

/**
 * 方法二：模拟枚举比较每个字符
 */
class MagicDictionary_2 {
    String[] words;

    public MagicDictionary_2() {
    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : words) {
            if (word.length() != searchWord.length()) continue;
            int diffCount = 0;
            int i = 0;
            for (char c : word.toCharArray()) {
                if (c != searchWord.charAt(i++)) diffCount++;
            }
            if (diffCount == 1) return true;
        }
        return false;
    }

}
