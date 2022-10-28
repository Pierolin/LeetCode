package q17;

import java.util.HashMap;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 * Count Items Matching a Rule
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 */
public class L1773_CountMatches {
    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        // int idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;

        int idx = new HashMap<String, Integer>() {{
            put("type", 0);
            put("color", 1);
            put("name", 2);
        }}.get(ruleKey);

        for (List item : items) {
            count += item.get(idx).equals(ruleValue) ? 1 : 0;
        }
        return count;
    }
}
