package q4;

/**
 * 427. 建立四叉树
 * https://leetcode.cn/problems/construct-quad-tree/
 */
public class L427_Construct {
    /**
     * 方法一：递归法
     * TC: O(n^2)
     * SC: O(n^2)
     */
    public Node construct_1(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        for (int r = r0; r < r1; r++) {
            for (int c = c0; c < c1; c++) {
                if (grid[r][c] != grid[r0][c0]) {
                    Node topLeft = dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2);
                    Node topRight = dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1);
                    Node bottomLeft = dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2);
                    Node bottomRight = dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1);
                    return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
                }
            }
        }
        return new Node(grid[r0][c0] == 1, true);
    }

    /**
     * 方法一：递归 + 前缀和
     * TC: O(n^2logn)
     * SC: O(logn)
     */
    public Node construct_2(int[][] grid) {
        int len = grid.length;
        int[][] sum = new int[len + 1][len + 1];
        for (int r = 1; r <= len; r++) {
            for (int c = 1; c <= len; c++) {
                sum[r][c] = sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1] + grid[r - 1][c - 1];
            }
        }
        return dfs(grid, sum, 0, 0, len, len);
    }

    public Node dfs (int[][] grid, int[][] sum, int r0, int c0, int r1, int c1) {
        int total = sum[r1][c1] - sum[r1][c0] - sum[r0][c1] + sum[r0][c0];
        if (total== 0 || total == (r1 - r0) * (c1 - c0)) {
            return new Node(total > 0, true);
        }

        Node topLeft = dfs(grid, sum, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2);
        Node topRight = dfs(grid, sum, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1);
        Node bottomLeft = dfs(grid, sum, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2);
        Node bottomRight = dfs(grid, sum, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}


// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
