package q14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * String Matching in an Array
 * https://leetcode.cn/problems/string-matching-in-an-array/
 */
public class L1408_StringMatching {

    /**
     * 方法一：暴力枚舉
     * TC: O(n^2)
     * SC: O(1)
     */
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList();
        if (words == null || words.length < 2) return list;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 方法二：拼接字符串
     * @param words
     * @return
     */
    public List<String> stringMatching_2(String[] words) {
        List<String> list = new ArrayList<>();
        String str = String.join("#", words);
        for(String word : words) {
            if (str.indexOf(word) != str.lastIndexOf(word)) list.add(word);
        }
        return list;
    }
}
