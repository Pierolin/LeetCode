public class L463_IslandPerimeter {

    /**
     * 方法一：暴力迭代法
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 统计岛屿个数和邻居个数，如 A 与 B 互为邻居，则邻居个数为 2;
     * 2. 周长 = 岛屿个数 * 4 - 邻居个数 * 2
     */
    public int islandPerimeter_1(int[][] grid) {
        if (grid == null) return 0;
        int islands = 0;
        int neighbour = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    islands++;
                    //if (r > 0 && grid[r - 1][c] == 1) neighbour++;
                    if (r < grid.length - 1 && grid[r + 1][c] == 1) neighbour++;
                    //if (c > 0 && grid[r][c - 1] == 1) neighbour++;
                    if (c < grid[0].length - 1 && grid[r][c + 1] == 1) neighbour++;
                }
            }
        }
        //return islands * 4 - neighbour;
        return islands * 4 - neighbour * 2;
    }

    /**
     * 方法一：暴力迭代法
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 遍历每个格子，把每个格子的周长加起来;
     * 2. 为 1 的格子周长为 4，如果某边有跟其它为 1 的格子靠在一起，则 -1。
     */
    public int islandPerimeter_2(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) continue;
                perimeter += calculate(r, c, grid);
            }
        }
        return perimeter;
    }

    private int calculate(int r, int c, int[][] grid) {
        int len = 4;
        if (r > 0 && grid[r - 1][c] == 1) len--;
        if (r < grid.length - 1 && grid[r + 1][c] == 1) len--;
        if (c > 0 && grid[r][c - 1] == 1) len--;
        if (c < grid[0].length - 1 && grid[r][c + 1] == 1) len--;
        return len;
    }


    /**
     * 方法二：DFS
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 找到第 1 个为 1 的格子，从这个格子开始顺藤摸瓜找到其它所有为 1 的格子，
     * 2. 顺藤摸瓜找格子的同时计算当前格子的周长;
     * 3. 创建一个布尔数组用来记录访问过的格子。
     */
    public int islandPerimeter_3(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) return calculate_2(r, c, grid, visited);
            }
        }
        return 0;
    }

    private int calculate_2(int r, int c, int[][] grid, boolean[][] visited) {
        if (visited[r][c]) return 0;
        visited[r][c] = true;
        int perimeter = 4;
        if (r > 0 && grid[r - 1][c] == 1) {
            perimeter--;
            perimeter += calculate_2(r - 1, c, grid, visited);
        }
        if (r < grid.length - 1 && grid[r + 1][c] == 1) {
            perimeter--;
            perimeter += calculate_2(r + 1, c, grid, visited);
        }
        if (c > 0 && grid[r][c - 1] == 1) {
            perimeter--;
            perimeter += calculate_2(r, c - 1, grid, visited);

        }
        if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
            perimeter--;
            perimeter += calculate_2(r, c + 1, grid, visited);

        }
        return perimeter;
    }
}
