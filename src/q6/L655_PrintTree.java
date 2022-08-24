package q6;

import share.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 655. 输出二叉树
 * Print Binary Tree
 * https://leetcode.cn/problems/print-binary-tree/
 */
public class L655_PrintTree {
    /**
     * 方法一：BFS + DFS
     * TC: O(n)
     * SC: O(n)
     */
    public List<List<String>> printTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int m = 0;
        while (!queue.isEmpty()) {
            m++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }

        int height = m - 1;
        int n = (int) Math.pow(2, height + 1) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            List<String> row = new ArrayList<>();
            for (int c = 0; c < n; c++) row.add("");
            res.add(row);
        }

        int row = 0;
        int col = (n - 1) / 2;
        res.get(row).set(col, String.valueOf(root.val));
        dfs(res, root, height, row, col);
        return res;
    }

    public void dfs(List<List<String>> res, TreeNode node, int height, int row, int col) {
        if (node.left == null && node.right == null) return;

        if (node.left != null) {
            int currRow = row + 1;
            int currCol = col - (int) Math.pow(2, height - row - 1);
            res.get(currRow).set(currCol, String.valueOf(node.left.val));
            dfs(res, node.left, height, currRow, currCol);
        }

        if (node.right != null) {
            int currRow = row + 1;
            int currCol = col + (int) Math.pow(2, height - row - 1);
            res.get(currRow).set(currCol, String.valueOf(node.right.val));
            dfs(res, node.right, height, currRow, currCol);
        }
    }
}
