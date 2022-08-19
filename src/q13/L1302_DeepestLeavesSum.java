package q13;

import share.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L1302_DeepestLeavesSum {
    int deepest = 0;
    int sum = 0;

    /**
     * 方法一：DFS
     * TC: O(n)
     * SC: O(1)
     */
    public int deepestLeavesSum(TreeNode root) {
        dfs(1, root);
        return sum;
    }

    public void dfs(int deep, TreeNode root) {
        if (root.left == null && root.right == null) {
            if (deep > deepest) {
                sum = root.val;
                deepest = deep;
            } else if (deep == deepest) {
                sum += root.val;
            }
            return;
        }
        if (root.left != null) dfs(deep + 1, root.left);
        if (root.right != null) dfs(deep + 1, root.right);
    }

    /**
     * 方法一：BFS
     * TC: O(n)
     * SC: O(n)
     */
    public int deepestLeavesSum_2(TreeNode root) {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        int sum = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            sum = 0;
            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                if (node.left == null && node.right == null) sum += node.val;
                if (node.left != null) nodes.addLast(node.left);
                if (node.right != null) nodes.addLast(node.right);
            }
        }
        return sum;
    }
}
