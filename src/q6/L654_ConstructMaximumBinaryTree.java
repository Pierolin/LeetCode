package q6;

import share.TreeNode;

public class L654_ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    public TreeNode dfs(int[] nums, int from, int to) {
        if (from > to) return null;
        int maxI = from;
        for (int i = from + 1; i <= to; i++) {
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxI]);
        node.left = dfs(nums, from, maxI - 1);
        node.right = dfs(nums, maxI + 1, to);
        return node;
    }
}
