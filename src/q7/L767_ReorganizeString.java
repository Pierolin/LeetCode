package q7;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 * https://leetcode-cn.com/problems/reorganize-string/
 */
public class L767_ReorganizeString {
    /**
     * 方法一：计数 + 大顶堆
     * Time: O(n)
     * Space: O(1)
     * 解题思路:
     */
    public String reorganizeString_1(String S) {
        int maxCount = 0;
        int maxIndex = 0;
        int[] counts = new int[26];
        for (char c : S.toCharArray()) {
            int i = c - 'a';
            counts[i]++;
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }

        if (maxCount > ((S.length() + 1) >> 1)) return "";

        char[] chars = new char[S.length()];
        int n = 0;
        // 把字母最多的加过到偶数索引位
        while (counts[maxIndex]-- > 0) {
            chars[n] = (char) (maxIndex + 'a');
            n += 2;
        }
        // 把其它字母也加过进去
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                while (counts[i]-- > 0) {
                    // 偶数索引位满后加奇数位
                    if (n > S.length() - 1) n = 1;
                    chars[n] = (char) (i + 'a');
                    n += 2;
                }
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 方法二：计数 + 大顶堆
     * Time: O(nlogn)
     * Space: O(n)
     * 解题思路:
     */
    public String reorganizeString(String S) {
        int maxCount = 0;
        int[] counts = new int[26];
        for (char c : S.toCharArray()) {
            int i = c - 'a';
            counts[i]++;
            maxCount = Math.max(maxCount, counts[i]);
        }

        if (maxCount > ((S.length() + 1) >> 1)) return "";

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        /* 另外 2 种比较器写法 */
        // PriorityQueue<Character> queue = new PriorityQueue<>((o1,o2)->counts[o2 - 'a'] - counts[o1 - 'a']);
        // PriorityQueue<Character> queue2 = new PriorityQueue<>(Comparator.comparingInt(o -> -counts[o - 'a']));
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) queue.offer(c);
        }

        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            int i1 = c1 - 'a';
            int i2 = c2 - 'a';
            counts[i1]--;
            counts[i2]--;
            if (counts[i1] > 0) queue.offer(c1);
            if (counts[i2] > 0) queue.offer(c2);
        }

        if (queue.size() > 0) sb.append(queue.poll());

        return sb.toString();
    }


}
