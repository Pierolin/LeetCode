package q9;

import java.util.HashSet;
import java.util.Set;

public class L902_AtMostNGivenDigitSet {

    /**
     * 方法一：数学法
     * TC: O(n)
     * SC: O(n)
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int count = 0;
        int lenDigits = digits.length;
        char[] nums = String.valueOf(n).toCharArray();
        int lenNums = nums.length;
        int[] lenEquals = new int[10];
        Set<String> set = new HashSet<>();

        for (String digit : digits) set.add(digit);
        for (int i = 0; i < lenDigits; i++) lenEquals[Integer.parseInt(digits[i])] = i + 1;
        for (int i = 1; i < 10; i++) lenEquals[i] = Math.max(lenEquals[i], lenEquals[i - 1]);

        for (int i = 1; i < lenNums; i++) count += Math.pow(lenDigits, i);
        for (int i = 0; i < lenNums; i++) {
            char num = nums[i];
            int j = nums[i] - '0';
            String digit = String.valueOf(num);
            int pows = (int) Math.pow(lenDigits, lenNums - 1 - i);
            if (set.contains(digit)) {
                count += (lenEquals[j] - 1) * pows;
                if (i == lenNums - 1) count++;
            } else {
                count += lenEquals[j] * pows;
                break;
            }
        }
        return count;
    }
}
