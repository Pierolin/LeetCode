import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class L222_CountNodes {
    /**
     * 方法二：完全二叉树和满二叉树的特性
     * Time: O(logn)
     * Space: O(n)
     * 解题思路：
     * 1. 树的深度为 h, 满二叉树节点个数 = 2^n - 1 = (1 << h) - 1;
     * 2. 左子树深度 == 右子树深度，则左子树为满二叉树，总节点数 = 根节点(1) + 左满二叉树节点数 + 右子树节点数;
     * 3. 左子树深度 != 右子树深度，则右子树为满二叉树，总节点数 = 根节点(1) + 左子树节点数 + 右满二叉子树节点数;
     */
    public int countNodes_2(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight) {
            return 1 + ((1 << leftHeight) - 1) + countNodes_2(root.right);
        } else {
            return 1 + countNodes_2(root.left) + ((1 << rightHeight) - 1);
        }
    }

    /**
     * 计算完全二叉树的高度
     */
    private int height(TreeNode node) {
        return node == null ? 0 : 1 + height(node.left);
        /*
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
        */
    }

    /**
     * 方法一(1)：DFS + 递归
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 深度优先递归访问每一节点，每访问一个节点计数 + 1
     */
    int count = 0;

    public int countNodes_3(TreeNode root) {
        if (root == null) return 0;
        count++;
        countNodes_3(root.left);
        countNodes_3(root.right);
        return count;
    }

    /**
     * 方法一(2)：DFS + 递归
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 节点总数 = 左子树节点之和 + 右子树节点之和 + 当前节点
     */
    public int countNodes_4(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes_4(root.left) + countNodes_4(root.right);
    }

    /**
     * 方法二：BFS
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1.
     */
    public int countNodes_5(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        //Deque<TreeNode> queue = new ArrayDeque<>();
        //deque.push(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //TreeNode node = queue.pop();
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return count;
    }
}
