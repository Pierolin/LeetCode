import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 */
public class L842_SplitIntoFibonacci {
    /**
     * 方法一：回溯法
     * Time: O(nlogn)
     * Space: O(n)
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        char[] digits = S.toCharArray();
        backtrack(digits, list, 0);
        return list;
    }

    private boolean backtrack(char[] digits, List<Integer> list, int start) {
        if (start == digits.length && list.size() >= 3) {
            return true;
        }

        for (int i = start; i < digits.length; i++) {
            if (digits[start] == '0' && i > start) break;
            long num = subDigit(digits, start, i + 1);
            if (num > Integer.MAX_VALUE) break;
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) break;
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (backtrack(digits, list, i + 1)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }

        return false;
    }

    private long subDigit(char[] digits, int start, int end) {
        long num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + (digits[i] - '0');
        }
        return num;
    }
}
