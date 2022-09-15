package q6;

import share.TreeNode;

public class L669_TrimBST {
    /**
     * 方法一：递归 DFS
     * TC: O(n)
     * SC: O(n)
     */
    public TreeNode trimBST_1(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) trimBST_1(root.right, low, high);
        if (root.val > high) trimBST_1(root.left, low, high);
        root.left = trimBST_1(root.left, low, high);
        root.right = trimBST_1(root.right, low, high);
        return root;
    }

    /**
     * 方法二：迭代法
     * TC: O(n)
     * SC: O(1)
     */
    public TreeNode trimBST_2(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (root == null) return null;

        TreeNode nodeL = root;
        TreeNode nodeR = root;

        while (nodeL.left != null) {
            if (nodeL.left.val < low) {
                nodeL.left = nodeL.left.right;
            } else {
                nodeL = nodeL.left;
            }
        }

        while (nodeR.right != null) {
            if (nodeR.right.val > high) {
                nodeR.right = nodeR.right.left;
            } else {
                nodeR = nodeR.right;
            }
        }
        return root;
    }
}
