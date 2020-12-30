package q0;


import share.TreeNode;
import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class L94_InorderTraversal {
    /**
     * 方法一：递归 + DFS
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 中序遍历顺序：left -> root - right
     * 2. DFS
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    /**
     * 方法二：迭代 + 栈
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 把所有 left 节点都压入栈内，再逐一取出，取出时把值加入列表，然后用一样的方式扫描 right 节点
     */
    public List<Integer> inorderTraversal_3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            /** 写法一 **/
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            /** 写法二 **/
            /*
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
            */
        }
        return list;
    }
}
