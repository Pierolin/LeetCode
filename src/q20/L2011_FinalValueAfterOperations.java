package q20;

import java.util.Arrays;

/**
 * 2011. 执行操作后的变量值
 * Final Value of Variable After Performing Operations
 */
public class L2011_FinalValueAfterOperations {
    /**
     * 方法一： equals 法
     * TC: O(n)
     * SC: O(1)
     */
    public int FinalValueAfterOperations_1(String[] operations) {
        int x = 0;
        for (String op : operations) {
            x += (op.equals("X++") || op.equals("++X") ? 1 : -1);
        }
        return x;
    }

    /**
     * 方法二： contains 法
     * TC: O(n)
     * SC: O(1)
     */
    public int FinalValueAfterOperations_2(String[] operations) {
        int x = 0;
        for (String op : operations) {
            x += (op.contains("++") ? 1 : -1);
        }
        return x;
    }


    /**
     * 方法三： charAt 法
     * TC: O(n)
     * SC: O(1)
     */
    public int FinalValueAfterOperations_3(String[] operations) {
        int x = 0;
        for (String op : operations) {
            x += (op.charAt(1) == '+' ? 1 : -1);
        }
        return x;
    }

    /**
     * 方法四： stream 法
     * TC: O(n)
     * SC: O(1)
     */
    public int FinalValueAfterOperations_4(String[] operations) {
        return Arrays.stream(operations).mapToInt(s -> 44 - s.charAt(1)).sum();
    }


}
