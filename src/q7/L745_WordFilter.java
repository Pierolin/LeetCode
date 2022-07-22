package q7;

import java.util.HashMap;
import java.util.Map;

/**
 * 745. Prefix and Suffix Search
 * 前缀和后缀搜索
 * https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 */
public class L745_WordFilter {
    Map<String, Integer> dictionary;

    public L745_WordFilter(String[] words) {
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int prefLen = 1; prefLen <= len; prefLen++) {
                for (int suffLen = 1; suffLen <= len; suffLen++) {
                    dictionary.put(word.substring(0, prefLen) + "#" + word.substring(len - suffLen), i);
                }
            }
        }
    }


    public int f(String pref, String suff) {
        return dictionary.getOrDefault(pref + "#" + suff, -1);

    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */