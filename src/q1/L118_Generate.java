package q1;

import java.util.ArrayList;
import java.util.List;

public class L118_Generate {
    /**
     * 方法一：数学法
     * Time: O(n^2)
     * Space: O(1)
     * 解题思路：
     * 1. 确定第 1 个原素;
     * 2. 其它任何原素为上一行列表同列及前一列数字之和, 如果上一行列表的前一列或同列不存在则为 0.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows < 1) return list;

        for (int r = 0; r < numRows; r++) {
            List<Integer> curr = new ArrayList<>();
            if (r == 0) {
                curr.add(1);
            } else {
                List<Integer> prev = list.get(r - 1);
                for (int c = 0; c < r + 1; c++) {
                    int num = (c == 0 ? 0 : prev.get(c - 1)) + (c == r ? 0 : prev.get(c));
                    curr.add(num);
                }
            }
            list.add(curr);
        }

        return list;
    }
}
