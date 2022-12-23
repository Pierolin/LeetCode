package q19;

/**
 * 1945. 字符串转化后的各位数字之和
 * Sum of Digits of String After Convert
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/description/
 */
public class L1945_GetLucky {

    /**
     * 方法一：字符数字转换法
     * TC: O(n)
     * SC: O(n)
     */
    public int getLucky_1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(c - 'a' + 1);
        String str = sb.toString();
        while (k-- > 0) {
            int sum = 0;
            for (char c : str.toCharArray()) sum += c - '0';
            str = String.valueOf(sum);
        }
        return Integer.parseInt(str);
    }

    /**
     * 方法二：取模取余法
     * TC: O(n)
     * SC: O(1)
     */
    public int getLucky_2(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int pos = c - 'a' + 1;
            sum += pos % 10 + pos / 10;
        }
        while (k-- > 1) {
            int num = sum;
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
        }
        return sum;
    }
}
