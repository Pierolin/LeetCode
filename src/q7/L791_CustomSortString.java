package q7;

public class L791_CustomSortString {

    /**
     * 方法一：数组计数
     * TC: O(n)
     * SC: O(1)
     */
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] dict = new int[26];
        for (char c : s.toCharArray()) dict[c - 'a']++;
        for (char c : order.toCharArray()) {
            int i = c - 'a';
            if (dict[i] > 0) {
                while (dict[i]-- > 0) sb.append(c);
            }
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] > 0) {
                while (dict[i]-- > 0) sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
