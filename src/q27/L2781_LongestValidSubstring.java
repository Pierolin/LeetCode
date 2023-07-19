package q27;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L2781_LongestValidSubstring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int max = 0;
        int n = word.length();
        int left = 0;
        int right = 0;
        Set<String > set = new HashSet<>();
        set.addAll(forbidden);
        while (right < n) {
            for (int i = right; i >= left && i > right - 10; i--) {
                String sub = word.substring(i, right + 1);
                if (set.contains(sub)) {
                    left = i + 1;
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
