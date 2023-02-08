package q23;

import share.TreeNode;

/**
 * 2331. 计算布尔二叉树的值
 * Evaluate Boolean Binary Tree
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree
 */
public class L2331_EvaluateTree {
    public boolean evaluateTree(TreeNode root) {
        // if (root.val == 0 || root.val == 1) return root.val == 1;
        if (root.left == null) return root.val == 1;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left || right : left && right;
    }
}
