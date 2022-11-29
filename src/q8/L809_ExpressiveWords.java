package q8;

import java.util.ArrayList;
import java.util.List;

public class L809_ExpressiveWords {

    /**
     * 方法一：模拟统计
     * TC: O(n^2)
     * SC: O(1)
     */
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        List<Integer[]> target = generate(s);
        for (String w : words) {
            List<Integer[]> original = generate(w);
            if (isStretchy(target, original)) ans++;
        }
        return ans;
    }

    private List<Integer[]> generate(String word) {
        List<Integer[]> list = new ArrayList<>();
        int curr = -1;
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c - '0' == curr) {
                count++;
            } else {
                if (count > 0) list.add(new Integer[]{curr, count});
                count = 1;
                curr = c - '0';
            }
        }
        list.add(new Integer[]{curr, count});
        return list;
    }

    private boolean isStretchy(List<Integer[]> target, List<Integer[]> original) {
        if (target.size() != original.size()) return false;
        boolean hasExtend = false;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i)[0] != original.get(i)[0]) return false;
            if (target.get(i)[1] < original.get(i)[1]) return false;
            if (target.get(i)[1] > original.get(i)[1]) {
                if (target.get(i)[1] < 3) return false;
                hasExtend = true;
            }
        }
        return hasExtend;
    }
}
