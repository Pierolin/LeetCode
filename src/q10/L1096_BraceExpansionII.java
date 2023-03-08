package q10;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 1096. 花括号展开 II
 * Brace Expansion II
 * https://leetcode.cn/problems/brace-expansion-ii
 */
public class L1096_BraceExpansionII {

    TreeSet<String> set = new TreeSet<>();

    /**
     * 方法一：递归 (DFS)
     * TC: O(n×2^(n/4))
     * SC: O(n)
     */
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList(set);
    }

    private void dfs(String expression) {
        int end = expression.indexOf("}");
        if (end == -1) {
            set.add(expression);
            return;
        }
        int start = expression.lastIndexOf("{", end);

        String left = expression.substring(0, start);
        String right = expression.substring(end + 1);
        String[] middles = expression.substring(start + 1, end).split(",");
        for (String mid : middles) {
            //dfs(left + mid + right);
            StringBuilder sb = new StringBuilder(left);
            sb.append(mid).append(right);
            dfs(sb.toString());
        }
    }
}
