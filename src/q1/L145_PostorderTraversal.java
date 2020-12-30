package q1;

import share.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */

public class L145_PostorderTraversal {
    /**
     * 方法一：递归
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 中序遍历顺序：left -> right - root
     * 2. DFS
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        dfs(list, root.right);
        list.add(root.val);
    }

    /**
     * 方法二：迭代 + 栈
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 使用 2 个栈，1 个用来迭代用，另 1 个存储最终结果;
     */
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> tempStack = new LinkedList<>();
        Deque<TreeNode> resultStack = new LinkedList<>();
        tempStack.push(root);

        while (!tempStack.isEmpty()) {
            root = tempStack.pop();
            resultStack.push(root);
            if (root.left != null) {
                tempStack.push(root.left);
            }
            if (root.right != null) {
                tempStack.push(root.right);
            }
        }

        while (!resultStack.isEmpty()) {
            list.add(resultStack.pop().val);
        }
        return list;
    }

}
