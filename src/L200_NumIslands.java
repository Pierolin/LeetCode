import java.util.Deque;
import java.util.LinkedList;

public class L200_NumIslands {
    /**
     * 方法一：DFS + 递归
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 设置一布尔数组用来记录哪些格子已访问过;
     * 2. DFS 递归遍历 1 的上下左右为 1 的格子，把为 1 的标为已访问;
     */
    public int numIslands_1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int nums = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    nums++;
                    setVisited(r, c, visited, grid);
                }
            }
        }

        return nums;
    }

    private void setVisited(int r, int c, boolean[][] visited, char[][] grid) {
        if (r < 0 || r > visited.length - 1 || c < 0 || c > visited[0].length - 1 || visited[r][c] || grid[r][c] == '0')
            return;
        visited[r][c] = true;
        setVisited(r - 1, c, visited, grid);
        setVisited(r + 1, c, visited, grid);
        setVisited(r, c - 1, visited, grid);
        setVisited(r, c + 1, visited, grid);
    }

    /**
     * 方法二：BFS
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 设置一布尔数组用来记录哪些格子已访问过;
     * 2. BFS 遍历 1 的上下左右为 1 的格子并把它们加入栈里，再一一取出设置已访问
     */
    public int numIslands_2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int nums = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    nums++;
                    Deque<Integer> stack = new LinkedList<>();
                    stack.push(r * cols + c);
                    while (!stack.isEmpty()) {
                        int id = stack.pop();
                        int i = id / cols;
                        int j = id % cols;
                        visited[i][j] = true;
                        if (i - 1 > -1 && grid[i - 1][j] == '1' && !visited[i - 1][j]) stack.push((i - 1) * cols + j);
                        if (i + 1 < rows && grid[i + 1][j] == '1' && !visited[i + 1][j]) stack.push((i + 1) * cols + j);
                        if (j - 1 > -1 && grid[i][j - 1] == '1' && !visited[i][j - 1]) stack.push(i * cols + (j - 1));
                        if (j + 1 < cols && grid[i][j + 1] == '1' && !visited[i][j + 1]) stack.push(i * cols + (j + 1));
                    }
                }
            }
        }

        return nums;
    }
}
