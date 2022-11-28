package q17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1742_CountBalls {

    /**
     * 方法二：数组计数
     * TC: O(n×logm)
     * SC: O(n×logm)
     */
    public int countBalls_2(int lowLimit, int highLimit) {
        int[] arr = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) ++arr[sum(i)];
        return Arrays.stream(arr).max().getAsInt();
    }

    /**
     * 方法二：哈希表
     * TC: O(n×logm)
     * SC: O(n×logm)
     */
    public int countBalls_1(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = sum(i);
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
            max = Math.max(max, count);
        }
        return max;
    }

    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
