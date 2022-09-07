package q6;

import share.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * Find Duplicate Subtrees
 * https://leetcode.cn/problems/find-duplicate-subtrees/
 */
public class L652_FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    /**
     * 方法一：DFS
     * TC: O(n)
     * SC: O(n)
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return list;
    }

    private String dfs(TreeNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",").append(dfs(node.left)).append(",").append(dfs(node.right));
        String key = sb.toString();
        if (map.getOrDefault(key, 0) == 1) list.add(node);
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
