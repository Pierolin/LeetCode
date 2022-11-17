package q7;

import java.util.*;

public class L792_NumMatchingSubseq {
    /**
     * 方法一：分桶 (多指针）
     * TC: O(sum(m.length) + n)
     * SC: O(n)
     */
    public int numMatchingSubseq_2(String s, String[] words) {
        int num = 0;
        Deque[] deques = new Deque[26];
        for (int i = 0; i < 26; i++) deques[i] = new ArrayDeque();
        for (String w : words) deques[w.charAt(0) - 'a'].offer(w);

        for (char c : s.toCharArray()) {
            Deque<String> d = deques[c - 'a'];
            int size = d.size();
            while (size-- > 0) {
                String str = d.poll();
                if (str.length() == 1) {
                    num++;
                } else {
                    deques[str.charAt(1) - 'a'].offer(str.substring(1));
                }
            }
        }

        return num;
    }

    /**
     * 方法一：哈希表 + 二分查找
     * TC: O(sum(m.length) × logn)
     * SC: O(m)
     */
    public int numMatchingSubseq_1(String s, String[] words) {
        int num = 0;
        Map<Character, List> original = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = original.getOrDefault(c, new ArrayList<Integer>());
            list.add(i);
            original.put(c, list);
        }

        for (String word : words) {
            if (isSubseq(original, word)) num++;
        }
        return num;
    }

    private boolean isSubseq(Map<Character, List> original, String word) {
        int prev = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!original.containsKey(c)) return false;
            List<Integer> list = original.get(c);
            int j = binarySearch(list, prev);
            if (j == list.size()) return false;
            int curr = list.get(j);
            if (curr > prev) {
                prev = curr;
            } else {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(List<Integer> list, int target) {
        int n = list.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int i = list.get(mid);
            if (i <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
