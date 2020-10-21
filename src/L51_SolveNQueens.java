import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class L51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        String[][] chess = new String[n][n];
        for (String[] chs : chess) {
            Arrays.fill(chs, "Q");
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                String[][] temp = new String[n][n];
                copy(chess, temp);
                setQueen(list, temp, r, c, 1);
            }
        }

        return list;
    }

    private void setQueen(List<List<String>> list, String[][] temp, int r, int c, int count) {
        int n = temp.length;
        if (count == n) {
            List<String> slist = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) str += temp[i][j];
                slist.add(str);
            }
            list.add(slist);
            return;
        }
        setDot(temp, r, c);
        temp[r][c] = "Q";
        for (int i = r + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == "Q") {
                    String[][] nTemp = new String[n][n];
                    copy(temp, nTemp);
                    setQueen(list, nTemp, i, j, count + 1);
                }
            }
        }
    }

    private void setDot(String[][] temp, int r, int c) {
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            temp[r][i] = ".";
            temp[i][c] = ".";
        }
        int tr = r, tc = c;
        while (tr < n && tc < n) temp[tr++][tc++] = ".";
        tr = r;
        tc = c;
        while (tr > -1 && tc > -1) temp[tr--][tc--] = ".";
        tr = r;
        tc = c;
        while (tr > -1 && tc < n) temp[tr--][tc++] = ".";
        tr = r;
        tc = c;
        while (tr < n && tc > -1) temp[tr++][tc--] = ".";
    }

    private void copy(String[][] sourceArr, String[][] destArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            for (int j = 0; j < sourceArr[i].length; j++) {
                destArr[i][j] = sourceArr[i][j];
            }
        }
    }


    public static void main(String[] args) {
        L51_SolveNQueens solveNQueens = new L51_SolveNQueens();
        List<List<String>> result = solveNQueens.solveNQueens(5);
        System.out.println(result.toString());

    }
}