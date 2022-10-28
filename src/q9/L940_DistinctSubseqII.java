package q9;

import java.util.HashSet;
import java.util.Set;

public class L940_DistinctSubseqII {
    /**
     * 方法二：动态规划
     * TC: O(n)
     * SC: O(1);
     * 参考题解：https://leetcode.cn/problems/distinct-subsequences-ii/solution/bu-tong-by-capital-worker-vga3/
     */
    public int distinctSubseqII_2(String s) {
        final int MOD = (int) 1e9 + 7;
        int[] newAdds = new int[26];
        int total = 1;
        for (int i = 0; i < s.length(); i++) {
            int newAdd = total;
            int j = s.charAt(i) - 'a';
            total = ((total + newAdd) % MOD - newAdds[j] % MOD + MOD) % MOD;
            newAdds[j] = newAdd;
        }
        return total - 1;
    }

    Set<String> set = new HashSet<>();

    /**
     * 方法一：暴力枚举+哈希(超时）
     * TC: O(n)
     * SC: O(n)
     */
    public int distinctSubseqII_1(String s) {
        dfs("", s);
        return set.size();
    }

    public void dfs(String prev, String s) {
        for (int i = 0; i < s.length(); i++) {
            String str = prev + s.charAt(i);
            set.add(str);
            dfs(str, s.substring(i + 1));
        }
    }
}
