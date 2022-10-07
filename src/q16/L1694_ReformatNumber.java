package q16;

/**
 * 1694. 重新格式化电话号码
 * Reformat Phone Number
 * https://leetcode.cn/problems/reformat-phone-number/
 */
public class L1694_ReformatNumber {
    public String reformatNumber(String number) {
        number = number.replaceAll(" |-", "");
        int n = number.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                sb.append(number.substring(i, i + 3) + "-");
                i += 3;
                n -= 3;
            } else if (n == 4) {
                sb.append(number.substring(i, i + 2) + "-");
                i += 2;
                sb.append(number.substring(i));
                break;
            } else {
                sb.append(number.substring(i));
                break;
            }
        }
        return sb.toString();
    }
}
