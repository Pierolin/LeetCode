package q11;

import share.TreeNode;

public class L1145_BtreeGameWinningMove {

    /**
     * 方法一：贪心法 + DFS
     * TC: O(n)
     * SC: O(n)
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findNode(root, x);
        int leftCount = countNodes(xNode.left);
        int rightCount = countNodes(xNode.right);
        int upCount = n - leftCount - rightCount - 1;
        // if (upCount > leftCount + rightCount + 1 || leftCount > upCount + rightCount + 1 || rightCount > upCount + leftCount + 1) return true;
        int half = n >> 1;
        if (upCount > half || leftCount > half || rightCount > half) return true;
        return false;
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        TreeNode left = findNode(node.left, x);
        if (left != null) return left;
        return findNode(node.right, x);
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return countNodes(node.left) + countNodes(node.right) + 1;
    }
}
