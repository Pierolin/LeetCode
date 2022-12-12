package q17;

public class L1781_BeautySum {
    /**
     * 方法一：暴力循环模拟
     * TC: O(n^2)
     * SC: O(1)
     */
    public int beautySum_1(String s) {
        int n = s.length();
        if (n < 3) return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                String sub = s.substring(i, j + 1);
                sum += calBeauty(sub);
            }
        }
        return sum;
    }

    int calBeauty(String s) {
        int n = s.length();
        int[] counts = new int[26];
        int max = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int cnt : counts) {
            if (cnt == 0) continue;
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        return max - min;
    }

    /**
     * 方法二：双层循环 + 记忆统计
     * TC: O(C×n^2)，其中 C 是 s 的元素种类，n 是 s 的长度。
     * SC: O(1)
     */
    public int beautySum_2(String s) {
        int n = s.length();
        if (n < 3) return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];
            int max = 0;
            for (int j = i; j < n; j++) {
                int cnt = ++counts[s.charAt(j) - 'a'];
                max = Math.max(max, cnt);
                int min = n;
                if (cnt == 1) {
                    min = 1;
                } else {
                    for (int c : counts) {
                        if (c > 0) min = Math.min(min, c);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
