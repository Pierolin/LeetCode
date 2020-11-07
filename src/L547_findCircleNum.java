/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class L547_findCircleNum {
    /**
     * 方法一：DFS(深度优先)
     * TC: O(n^2)
     * SC: O(n)
     * 解题关键：
     * 1. 递归找某个人的朋友及朋友的朋友的朋友...，所有找到的朋友形成一个朋友圈;
     * 2. 未被找到过的朋友形成新的朋友圈。
     */
    public int findCircleNum_1(int[][] M) {
        if (M == null || M.length == 0 || (M.length == 1 && M[0].length == 0)) return 0;

        int count = 0;
        int[] visited = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[0] == 0) {
                count++;
                dfs(M, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     * 方法二：并查集法
     * TC: O(n)
     * SC: O(n)
     */
    public int findCircleNum_2(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int n = M.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}

class UnionFind {
    private int count = 0;
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int m, int n) {
        int rootM = find(m);
        int rootN = find(n);
        if (rootM == rootN) return;
        if (rank[m] > rank[n]) {
            parent[rootN] = rootM;
        } else {
            parent[rootM] = rootN;
            if (rank[m] == rank[n]) rank[n]++;
        }
        count--;
    }

    public boolean connected(int m, int n) {
        return find(m) == find(n);
    }

    public int count() {
        return count;
    }
}
