import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class L102_LevelOrder {
    /**
     * dfs + 递归
     * TC: O(n)
     * SC: O(n)
     * 解题关键：
     * 1. 运用深度优先搜索 dfs;
     * 2. dfs 遍历在未折回之前的节点数题与当前层次相对应
     */
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (list.size() == level) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        if (root.left != null) dfs(root.left, level + 1, list);
        if (root.right != null) dfs(root.right, level + 1, list);
    }

    /**
     * bfs + 队列
     * TC: O(n)
     * SC: O(n)
     * 解题关键：
     * 1. 使用队列先进先出；
     * 2. 队列的长度即为本层数组大小。
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                nums.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(nums);
        }

        return list;
    }

}
