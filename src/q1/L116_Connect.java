package q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L116_Connect {
    /**
     * 方法一：递归 + DFS
     * TC: O(n)
     * Sc: O(1)
     * 解题关键：右节点的 next 节点 = 父亲节点的 next 节点的左节点
     */
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;

        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);

        return root;
    }

    /**
     * 方法二：递归 + 哈希 + DFS
     * TC: O(n)
     * Sc: O(1)
     * 解题关键：以层次 level 作为 map 的 key, 同一层的节点存入同一个 key 里
     */
    public Node connect_2(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        dfs(map, root, 0);
        return root;
    }

    private void dfs(Map<Integer, List<Node>> map, Node node, int level) {
        if (node == null || node.left == null || node.right == null) return;

        List<Node> list = map.getOrDefault(level, new ArrayList<Node>());
        if (list.size() > 0) {
            list.get(list.size() - 1).next = node.left;
        }
        list.add(node.left);
        list.add(node.right);
        node.left.next = node.right;
        map.put(level, list);
        dfs(map, node.left, level + 1);
        dfs(map, node.right, level + 1);
    }
}

class Node {
    int val;
    Node left, right, next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
