public class L861_MatrixScore {
    /**
     * 方法一： 贪心法
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 为取最大值，很显然只需把最高位变为 1, 如每行的第 1 位为 0，即翻转该行;
     * 2. 余下工作只需从第 2 列开始，根据需要而翻转，如果目前的列的 1 的数量少于 0 的数量就翻转它。
     */
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || (A.length == 1 && A[0].length == 0)) return 0;

        int rows = A.length;
        int cols = A[0].length;

        int score = (1 << cols - 1) * rows;

        for (int c = 1; c < cols; c++) {
            int oneCount = 0;
            for (int r = 0; r < rows; r++) {
                oneCount += A[r][0] == 1 ? A[r][c] : (A[r][c] == 0 ? 1 : 0);
            }
            oneCount = Math.max(oneCount, rows - oneCount);
            score += (1 << (cols - c - 1)) * oneCount;
        }

        return score;
    }
}
