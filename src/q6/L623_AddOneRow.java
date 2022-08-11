package q6;

import share.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 623. 在二叉树中增加一行
 * Add One Row to Tree
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class L623_AddOneRow {
    /**
     * 方法一：DFS
     * TC: O(n)
     * SC: O(n)
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;

        if (depth == 1) return new TreeNode(val, root, null);
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }

        return root;
    }

    /**
     * 方法一：BFS
     * TC: O(n)
     * SC: O(n)
     */
    public TreeNode addOneRow_2(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (level == depth - 1) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                } else {
                    if (node.left != null) deque.add(node.left);
                    if (node.right != null) deque.add(node.right);
                }
            }
            level++;
        }
        return root;
    }
}
