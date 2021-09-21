package q10;

import java.util.Arrays;
import java.util.OptionalInt;

public class L1011_ShipWithinDays {

    /**
     * 方法一：二分查找转化为判定问题
     * Time: O(nlogn)
     * Space: O(1)
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left < right) {
            int mid = (left + right) / 2;
            int days = calculate(weights, mid);
            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int calculate(int[] weights, int mid) {
        int days = 1;
        int sum = 0;
        for (int w : weights) {
            sum += w;
            if (sum > mid) {
                days++;
                sum = w;
            }
        }
        return days;
    }
}
