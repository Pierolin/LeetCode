package q1;


import share.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * Binary Tree Zigzag Level Order Traversal
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class L103_ZigzagLevelOrder {
    /**
     * 方法一： BFS (广度优先)
     * Time: O(n)
     * Space: O(n)
     * 关键思路：
     * 1. 使用队列进行深度优先遍历;
     * 2. 使用小技巧 nums.add(0, node.val) 把元素从右往左加
     */
    public List<List<Integer>> zigzagLevelOrder_1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft2Right = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List nums = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeft2Right) {
                    nums.add(node.val);
                } else {
                    nums.add(0, node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(nums);
            isLeft2Right = !isLeft2Right;
        }

        return list;
    }


    /**
     * 方法二：DFS (深度优先) + 递归
     * Time: O(n)
     * Space: O(n)
     * 关键思路：
     * 1. 使层序 level 与 list 的搜索一致;
     * 2. 使用小技巧 nums.add(0, node.val) 把元素从右往左加.
     */
    public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;
        if (list.size() == level) list.add(new LinkedList<>());
        List nums = list.get(level);
        if (level % 2 == 0) {
            nums.add(node.val);
        } else {
            nums.add(0, node.val);
        }
        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }
}
