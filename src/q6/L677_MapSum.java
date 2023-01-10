package q6;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：哈希模拟
 */
public class L677_MapSum {
    Map<String, Integer> map;

    public L677_MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) total += map.get(key);
        }
        return total;
    }
}


/**
 * 方法二：字典树 + DFS
 */
class MapSum_2 {
    Trie root;

    public MapSum_2() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        Trie node = root;
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new Trie();
            node = node.children[i];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Trie node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return 0;
            node = node.children[i];
        }
        return dfs(node);
    }

    private int dfs(Trie node) {
        if (node == null) return 0;
        int total = node.val;
        for (Trie child : node.children) total += dfs(child);
        return total;
    }
}

/**
 * 方法三：字典树 + 哈希表
 */
class MapSum_3 {
    Trie root;
    Map<String, Integer> map;

    public MapSum_3() {
        root = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        Trie node = root;
        int diff = val;
        if (map.containsKey(key)) diff = val - map.get(key);
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new Trie();
            node = node.children[i];
            node.val += diff;
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        Trie node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return 0;
            node = node.children[i];
        }
        return node.val;
    }
}

/**
 * 方法四：前缀哈希映射
 */
class MapSum_4 {
    Map<String, Integer> map;
    Map<String, Integer> prefixMap;

    public MapSum_4() {
        map = new HashMap();
        prefixMap = new HashMap();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + diff);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
}

class Trie {
    Trie[] children;
    int val;
    public Trie() {
        children = new Trie[26];
        val = 0;
    }
}
