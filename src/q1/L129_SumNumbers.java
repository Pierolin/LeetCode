package q1;


import share.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class L129_SumNumbers {


    /**
     * 方法一：递归 + DFS + 动态规划
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 动规方程：总路径和 = 左路径和 + 右路径和
     * 2. 带上父结点的路径和进行递归调用
     */
    public int sumNumbers_1(TreeNode root) {
        return recurDP(0, root);
    }

    private int recurDP(int val, TreeNode root) {
        if (root == null) return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) return val;
        return recurDP(val, root.left) + recurDP(val, root.right);
    }

    /**
     * 方法一：递归 + DFS
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 当左右节点都为 null 时，说明节点已到底部，可以得到到该底结点的路径和;
     */
    int sum = 0;

    public int sumNumbers_2(TreeNode root) {
        if (root == null) return 0;
        dfs(0, root);
        return sum;
    }

    private void dfs(int val, TreeNode root) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) dfs(val, root.left);
        if (root.right != null) dfs(val, root.right);
    }

    /**
     * 方法三：BFS
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 广度优先搜索;
     * 1. 设置两个栈，一个存节点，一个存节点值;
     */
    public int sumNumbers_3(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> valueStack = new LinkedList<>();
        nodeStack.push(root);
        valueStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            int num = valueStack.pop();
            if (root.left != null) {
                nodeStack.push(root.left);
                valueStack.push(num * 10 + root.left.val);
            }

            if (root.right != null) {
                nodeStack.push(root.right);
                valueStack.push(num * 10 + root.right.val);
            }

            if (root.left == null && root.right == null) {
                sum += num;
            }
        }
        return sum;
    }
}
