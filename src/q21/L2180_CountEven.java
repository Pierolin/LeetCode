package q21;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * Count Integers With Even Digit Sum
 * https://leetcode.cn/problems/count-integers-with-even-digit-sum/description/
 */
public class L2180_CountEven {
    /**
     * 方法一：暴力枚举
     * TC: O(nlogn）
     * SC: O(1)
     */
    public int countEven_1(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp = tmp / 10;
            }
            if (sum % 2 == 0) count++;
        }
        return count;
    }

    /**
     * 方法一：数学计算
     * TC: O(logn）
     * SC: O(1)
     */
    public int countEven_2(int num) {
        int count = num / 10 * 5 - 1;
        int last = num % 10;
        int sum = 0;
        int tmp = num;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp = tmp / 10;
        }
        if (sum % 2 == 0) {
            count += last / 2 + 1;
        } else {
            count += (last + 1) / 2;
        }

        return count;
    }
}
