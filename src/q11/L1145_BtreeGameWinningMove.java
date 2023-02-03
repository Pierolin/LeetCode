package q11;

import share.TreeNode;

public class L1145_BtreeGameWinningMove {

    /**
     * 方法一：贪心法 + DFS
     * TC: O(n)
     * SC: O(n)
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = searchXNode(root, x);
        int leftCount = countChildNodes(xNode.left);
        int rightCount = countChildNodes(xNode.right);
        int upCount = n - leftCount - rightCount - 1;
        if (upCount > leftCount + rightCount + 1 || leftCount > upCount + rightCount + 1 || rightCount > upCount + leftCount + 1) return true;
        return false;
    }

    private TreeNode searchXNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        TreeNode left = searchXNode(node.left, x);
        if (left != null) return left;
        return searchXNode(node.right, x);
    }

    private int countChildNodes(TreeNode node) {
        if (node == null) return 0;
        return countChildNodes(node.left) + countChildNodes(node.right) + 1;
    }
}
