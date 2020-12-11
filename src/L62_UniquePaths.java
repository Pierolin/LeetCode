import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class L62_UniquePaths {
    /**
     * 方法一：动态规划
     * Time:  O(n^2)
     * Space:  O(n^2)
     * 解题思路：
     * 1. 用二维数组表示网格;
     * 2. 当前格唯一路径数 = 上格路径数 + 左格路径数;
     * 3. 所有左侧边格和上侧边格的路径数均为 1;
     */
    public int uniquePaths_1(int m, int n) {
        if (m < 1 || n < 1) return 0;

        int[][] dp = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (r == 0 || c == 0) {
                    dp[r][c] = 1;
                } else {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * 方法二：动态规划 + 空间优化
     * Time:  O(n^2)
     * Space:  O(n)
     * 解题思路：
     * 1. 用一维数组存储当前行每一格的路径数，左侧边格和上侧边格的路径数均为 1， 默认先填充 1;
     * 2. 按行计算每一格并更改数组;
     * 2. 当前格唯一路径数 = 上格路径数 + 左格路径数;
     */
    public int uniquePaths_2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 方法三：排列组合公式计算
     * Time:  O(n)
     * Space:  O(1)
     * 解题思路：
     * 1. 总共需走 (m - 1) + (n - 1) = m + n - 2 步，这么多步中，其中 m - 1 步是向下的，即转换为从 m + n - 2 中选取 m - 1 的排列组合：
     */
    public int uniquePaths_3(int m, int n) {
        double res = 1;
        for (int i = 1; i < n; i++) {
            res = res * (m - 1 + i) / i;
        }
        return (int) res;
    }

    /**
     * 方法四：暴力递归 + 哈希缓存
     * Time: 
     * Space: O(n)
     * 解题思路：
     * 1. 当前格唯一路径数 = 上格路径数 + 左格路径数;
     * 2. 当网格只有一行或一列时，当前格路径数 = 1;
     * 3. 使用哈希表来缓存各网格的路径数。
     */
    Map<String, Integer> cache = new HashMap<>();

    public int uniquePaths_4(int m, int n) {
        if (m == 1 || n == 1) return 1;
        String key = m + "," + n;
        if (!cache.containsKey(key)) {
            int paths = uniquePaths_4(m - 1, n) + uniquePaths_4(m, n - 1);
            cache.put(key, paths);
        }
        return cache.get(key);
    }

    /**
     * 方法五：暴力递归 (超时)
     * Time: 
     * Space: 
     * 解题思路：
     * 1. 当前格唯一路径数 = 上格路径数 + 左格路径数;
     * 2. 当网格只有一行或一列时，当前格路径数 = 1.
     */
    public int uniquePaths_5(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths_4(m - 1, n) + uniquePaths_4(m, n - 1);
    }

}
