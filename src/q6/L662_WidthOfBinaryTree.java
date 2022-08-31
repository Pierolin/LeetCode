package q6;

import share.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 662. 二叉树最大宽度
 * Maximum Width of Binary Tree
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class L662_WidthOfBinaryTree {
    /**
     * 方法一：DFS
     * TC: O(n)
     * SC: O(n)
     */
    Map<Integer, Integer> map = new HashMap<>();
    int width = 0;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return width;
    }

    private void dfs(TreeNode node, int depth, int index) {
        if (node == null) return;
        if (!map.containsKey(depth)) map.put(depth, index);
        width = Math.max(width, index - map.get(depth) + 1);
        dfs(node.left, depth + 1, index * 2);
        dfs(node.right, depth + 1, index * 2 + 1);
    }

    /**
     * 方法一：BFS
     * TC: O(n)
     * SC: O(n)
     */
    public int widthOfBinaryTree_2(TreeNode root) {
        int width = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        root.val = 1;
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode leftMostNode = deque.peekFirst();
            TreeNode rightMostNode = deque.peekLast();
            width = Math.max(width, rightMostNode.val - leftMostNode.val + 1);
            while (size-- > 0) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    TreeNode leftNode = node.left;
                    leftNode.val = node.val * 2;
                    deque.addLast(leftNode);
                }
                if (node.right != null) {
                    TreeNode rightNode = node.right;
                    rightNode.val = node.val * 2 + 1;
                    deque.addLast(rightNode);
                }
            }
        }
        return width;
    }
}
