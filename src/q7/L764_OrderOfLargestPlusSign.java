package q7;

import java.util.Arrays;

public class L764_OrderOfLargestPlusSign {

    /**
     * 方法一：动态规划/前缀和
     * TC: O(n^2)
     * SC: O(n^2)
     */
    public int orderOfLargestPlusSign_2(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] r : grid) Arrays.fill(r, 1);
        for (int[] m : mines) grid[m[0]][m[1]] = 0;

        int[][] left = new int[n][n];
        int[][] top = new int[n][n];
        int[][] right = new int[n][n];
        int[][] bottom = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                }
                int x = n - 1 - i;
                int y = n - 1 - j;
                if (grid[x][y] == 1) {
                    right[x][y] = j > 0 ? right[x][y + 1] + 1 : 1;
                    bottom[x][y] = i > 0 ? bottom[x + 1][y] + 1 : 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(Math.min(left[i][j], top[i][j]), Math.min(right[i][j], bottom[i][j])));
            }
        }
        return ans;
    }


    /**
     * 方法一：暴力循环
     * TC: O(n^3)
     * SC: O(n^2)
     */
    public int orderOfLargestPlusSign_1(int n, int[][] mines) {
        int max = 0;
        int[][] grid = generateGrid(n, mines);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, countOrder(grid, n, r, c));
                }
            }
        }
        return max;
    }

    private int countOrder(int[][] grid, int n, int r, int c) {
        int left = countArmLength(grid, n, r, c, "left");
        if (left == 1) return 1;
        int right = countArmLength(grid, n, r, c, "right");
        if (right == 1) return 1;
        int up = countArmLength(grid, n, r, c, "up");
        if (up == 1) return 1;
        int down = countArmLength(grid, n, r, c, "down");
        if (down == 1) return 1;

        return Math.min(Math.min(left, right), Math.min(up, down));
    }

    private int countArmLength(int[][] grid, int n, int r, int c, String direction) {
        int len = 1;
        switch (direction) {
            case "left":
                for (int i = c - 1; i >= 0; i--) {
                    if (grid[r][i] == 0) break;
                    len++;
                }
                break;
            case "right":
                for (int i = c + 1; i < n; i++) {
                    if (grid[r][i] == 0) break;
                    len++;
                }
                break;
            case "up":
                for (int i = r - 1; i >= 0; i--) {
                    if (grid[i][c] == 0) break;
                    len++;
                }
                break;
            case "down":
                for (int i = r + 1; i < n; i++) {
                    if (grid[i][c] == 0) break;
                    len++;
                }
                break;
        }
        return len;
    }

    private int[][] generateGrid(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(grid[i], 1);
        for (int[] m : mines) grid[m[0]][m[1]] = 0;
        return grid;
    }
}
