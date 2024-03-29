package q22;

/**
 * 2287. 重排字符形成目标字符串
 * Rearrange Characters to Make Target String
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class L2287_RearrangeCharacters {
    /**
     * 方法一：计数模拟法
     * TC: O(n + m)
     * SC: O(1)
     */
    public int rearrangeCharacters_1(String s, String target) {
        int max = 0;
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        while (true) {
            for (char c : target.toCharArray()) {
                if (arr[c - 'a']-- == 0) return max;
            }
            max++;
        }
    }

    /**
     * 方法一：计数倍数法
     * TC: O(n + m)
     * SC: O(1)
     */
    public int rearrangeCharacters_2(String s, String target) {
        int max = s.length();
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char c : s.toCharArray()) sArr[c - 'a']++;
        for (char c : target.toCharArray()) tArr[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (tArr[i] > 0) max = Math.min(max, sArr[i] / tArr[i]);
        }
        return max;
    }
}
