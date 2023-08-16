package q26;

import java.util.HashSet;
import java.util.Set;

public class L2682_CircularGameLosers {
    /**
     * 方法一：哈希表
     * Time: O(n)
     * Space: O(n)
     */
    public int[] circularGameLosers_1(int n, int k) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int times = 0;
        int num = 1;
        while (true) {
            num += ++times * k;
            num %= n;
            if (num == 0) num = n;
            if (set.contains(num)) break;
            set.add(num);
        }
        int[] losers = new int[n - set.size()];
        int j = 0;
        for (int i = 2; i < n + 1; i++) {
            if (!set.contains(i)) losers[j++] = i;
        }
        return losers;
    }

    /**
     * 方法二：数组哈希
     * Time: O(n)
     * Space: O(n)
     */
    public int[] circularGameLosers_2(int n, int k) {
        boolean[] friends = new boolean[n];
        friends[0] = true;
        int times = 0;
        int num = 0;
        while (true) {
            num = (num + ++times * k) % n;
            if (friends[num]) break;
            friends[num] = true;
        }
        int[] losers = new int[n - times];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!friends[i]) losers[j++] = i + 1;
        }
        return losers;
    }
}
