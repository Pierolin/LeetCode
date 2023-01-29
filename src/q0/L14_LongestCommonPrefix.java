package q0;

public class L14_LongestCommonPrefix {
    /**
     * 方法一：二分法
     * TC: O(mnlogn)
     * SC: O(1)
     */
    public String longestCommonPrefix_1(String[] strs) {
        String str = strs[0];
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            int mid = left +((right - left) >> 1);
            if (isCommonPrefix(strs, str.substring(0, mid + 1))) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return str.substring(0, left);
    }

    private boolean isCommonPrefix(String[] strs, String prefix) {
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }

    /**
     * 方法二：纵向扫描
     * TC: O(mn)
     * SC: O(1)
     */
    public String longestCommonPrefix_2(String[] strs) {
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i == str.length() || c != str.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    /**
     * 方法三：横向扫描
     * TC: O(mn)
     * SC: O(1)
     */
    public String longestCommonPrefix_3(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) prefix = commonPrefix(prefix, strs[i]);
        return prefix;
    }

    /**
     * 方法四：分治算法
     * TC: O(mn)
     * SC: O(mlogn)
     */
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) return strs[left];
        int mid = left + ((right - left) >> 1);
        String str1 = longestCommonPrefix(strs, left, mid);
        String str2 = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(str1, str2);
    }

    private String commonPrefix(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) return str1.substring(0, i);
        }
        return str1.substring(0, n);
    }
}
