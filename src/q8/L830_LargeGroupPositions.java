package q8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L830_LargeGroupPositions {
    /**
     * 方法一：循环遍历
     * Time: O(n)
     * Space: O(1)
     * 解题关键：
     * 1. 遍历数组，使用 count 记录当前字符重复次数;
     * 2. 当下一字符与不同于当前字符，或已遍历至最后，此时如 count >= 3, 即可记录下始末位置加下结果。
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();

        int len = s.length();
        int count = 1;

        for (int i = 0; i < len; i++) {
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count >= 3) list.add(Arrays.asList(i - count + 1, i));
                count = 1;
            } else {
                count++;
            }
        }

        return list;
    }
}
