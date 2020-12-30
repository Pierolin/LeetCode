package q1;

import share.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class L144_PreorderTraversal {
    /**
     * 方法一：递归 + DFS
     * TC: O(n)
     * SC: O(n)
     * 解题关键
     * 1. 前序遍历顺序为：root -> left -> right
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    /**
     * 方法二：迭代 + 双端队列
     * TC: O(n)
     * SC: 0(n)
     * 解题关键
     * 1. 前序遍历顺序为：root -> left -> right
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            root = deque.pollFirst();
            list.add(root.val);
            if (root.right != null) deque.addFirst(root.right);
            if (root.left != null) deque.addFirst(root.left);
        }
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs(list, root.left);
        dfs(list, root.right);
    }

    /**
     * 方法三：迭代 + 栈
     * TC: O(n)
     * SC: 0(n)
     * 解题关键
     * 1. 前序遍历顺序为：root -> left -> right
     */
    public List<Integer> preorderTraversal_3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }



}

