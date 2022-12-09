package q18;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * Determine Color of a Chessboard Square
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 */
public class L1812_SquareIsWhite {

    /**
     * 方法二：数学法
     * TC: O(1)
     * SC: O(1)
     */
    public boolean squareIsWhite_2(String coordinates) {
        int col = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '1';
        return (col + row) % 2 == 1;
    }

    /**
     * 方法一：模拟法
     * TC: O(1)
     * SC: O(1)
     */
    public boolean squareIsWhite_1(String coordinates) {
        int col = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '1';
        boolean isWhite = col % 2 == 1;
        isWhite = row % 2 == 0 ? isWhite : !isWhite;
        return isWhite;
    }
}
