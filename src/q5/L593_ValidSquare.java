package q5;

import java.util.HashSet;
import java.util.Set;

/**
 * 593. Valid Square
 */

public class L593_ValidSquare {
    /**
     * 方法一：
     * TC: O(1)
     * SC: O(1)
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1 == null || p2 == null || p3 == null || p4 == null) return false;
        if (p1.length != 2 || p2.length != 2 || p3.length != 2 || p4.length != 2) return false;

        Set<Integer> set = new HashSet();

        set.add(countLength(p1, p2));
        set.add(countLength(p1, p3));
        set.add(countLength(p1, p4));
        set.add(countLength(p2, p3));
        set.add(countLength(p2, p4));
        set.add(countLength(p3, p4));

        if (set.size() != 2 || set.contains(0)) return false;
        Integer[] lens = set.toArray(new Integer[2]);
        return lens[0] == 2 * lens[1]  || lens[1] == 2 * lens[0];
    }
    private int countLength(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }
}
