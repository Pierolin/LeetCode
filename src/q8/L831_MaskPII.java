package q8;

/**
 * 831. 隐藏个人信息
 * Masking Personal Information
 * https://leetcode.cn/problems/masking-personal-information
 */
public class L831_MaskPII {
    /**
     * 方法一：模拟法
     * TC: O(n）
     * SC: O(1)
     */
    String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII(String s) {
        int idx = s.indexOf("@");
        if (idx > 1) {
            s = s.toLowerCase();
            return s.charAt(0) + "*****" + s.charAt(idx - 1) + s.substring(idx);
        } else {
            //s = s.replaceAll("[\\+|\\-|\\(|\\)| ]", "");
            //s = s.replaceAll("[^0-9]", "");
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) sb.append(c);
            }
            s = sb.toString();
            int n = s.length();
            /*
            if (n == 10) {
                return "***-***-" + s.substring(n - 4);
            } else {
                return "+" + "*".repeat(n - 10) + "-***-***-" + s.substring(n - 4);
            }
            */
            return country[n - 10] + "***-***-" + s.substring(n - 4);
        }
    }

}
