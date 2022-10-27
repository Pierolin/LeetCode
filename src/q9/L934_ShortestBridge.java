package q9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 934. 最短的桥
 * Shortest Bridge
 * https://leetcode.cn/problems/shortest-bridge/
 */
public class L934_ShortestBridge {

    int[][] grid;
    int n;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 方法一： DFS + BFS
     * TC: O(n^2)
     * SC: O(n)
     * 题解：求出一个岛屿的沙滩，再一层层填充沙滩(2), 一直到达另一个岛屿，层数就是所求的解。
     */
    public int shortestBridge_2(int[][] grid) {
        int shortest = 0;
        this.grid = grid;
        this.n = grid.length;
        List<int[]> beachCells = getBorderCells(1, 2);
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < beachCells.size(); i++) {
            int[] cell = beachCells.get(i);
            this.grid[cell[0]][cell[1]] = 2;
            stack.offerLast(cell);
        }

        while (!stack.isEmpty()) {
            shortest++;
            int size = stack.size();
            while (size-- > 0) {
                int[] cell = stack.pollFirst();
                int r = cell[0];
                int c = cell[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[1];
                    int nc = c + dir[0];
                    if (nr >= n || nr < 0 || nc >= n || nc < 0) continue;
                    if (this.grid[nr][nc] == 1) return shortest;
                    if (this.grid[nr][nc] == 0) {
                        this.grid[nr][nc] = 2;
                        stack.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }
        return shortest;
    }

    /**
     * 方法一： DFS
     * TC: O(n^2)
     * SC: O(n)
     * 题解：求出两个岛屿的沙滩，求两个沙滩的最近距离
     */
    public int shortestBridge_1(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        List<int[]> beachCells1 = getBorderCells(1, 2);
        List<int[]> beachCells2 = getBorderCells(1, 3);
        int shortest = 2 * n - 1;
        for (int i = 0; i < beachCells1.size(); i++) {
            int[] bc1 = beachCells1.get(i);
            for (int j = 0; j < beachCells2.size(); j++) {
                int[] bc2 = beachCells2.get(j);
                shortest = Math.min(shortest, distance(bc1, bc2));
            }
        }
        return shortest;
    }

    private int distance(int[] bc1, int[] bc2) {
        return Math.abs(bc2[0] - bc1[0]) + Math.abs(bc2[1] - bc1[1]) + 1;
    }

    private List<int[]> getBorderCells(int target, int value) {
        List<int[]> borderCells = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == target) {
                    dfs(target, value, r, c, borderCells);
                    return borderCells;
                }
            }
        }
        return borderCells;
    }

    public void dfs(int target, int value, int r, int c, List<int[]> borderCells) {
        grid[r][c] = value;
        for (int[] dir : dirs) {
            int nr = r + dir[1];
            int nc = c + dir[0];
            if (nr >= n || nr < 0 || nc >= n || nc < 0) continue;
            if (grid[nr][nc] == target) {
                dfs(target, value, nr, nc, borderCells);
            } else if (grid[nr][nc] == 0) {
                borderCells.add(new int[]{nr, nc});
            }
        }
    }
}
