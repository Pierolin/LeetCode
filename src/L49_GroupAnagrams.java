import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class L49_GroupAnagrams {
    /**
     * 方法一：排序哈希法
     * Time: O(nlogn)
     * Space: O(n)
     * 解题思路：
     *
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<String>());
            anagrams.add(strs[i]);
            map.put(key, anagrams);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
