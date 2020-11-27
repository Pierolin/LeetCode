public class L1370_SortString {
    public String sortString(String s) {
        int len = s.length();
        if (s == null || len == 0) return "";

        int[] counting = new int[26];
        for (char c : s.toCharArray()) counting[c - 'a']++;

        char[] chars = new char[len];
        int n = 0;
        outer:
        while (true) {
            for (int i = 0; i < 26; i++) {
                if (counting[i] == 0) continue;
                chars[n++] = (char) ('a' + i);
                counting[i]--;
                if (n == len) break outer;
            }
            for (int i = 25; i >= 0; i--) {
                if (counting[i] == 0) continue;
                chars[n++] = (char) ('a' + i);
                counting[i]--;
                if (n == len) break outer;
            }
        }

        return String.valueOf(chars);
    }
}
