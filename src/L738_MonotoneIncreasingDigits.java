/**
 * 738. 单调递增的数字
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class L738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        int pow = (int) Math.log10(N); // N 的位数
        int pow10 = (int) (Math.pow(10, pow)); // 比N小的最大 10^x
        int n = N / pow10; // N 的首位
        int threshold = n; // 继续递归的阈值
        for (int i = 0; i < pow; i++) threshold = threshold * 10 + n;
        // 如果小于阈值，返回 x999999..
        return N < threshold ? n * pow10 - 1 :
                n * pow10 + monotoneIncreasingDigits(N - n * pow10);
    }

    /**
     * 方法一：取余取模法
     * Time: O(logN) N 为输入参数
     * Space: O(logN) N 为输入参数
     * 解题思路：
     * 1. 既然要尽可能的大，那么这个数从高位开始要尽可能地保持不变，从低位向高位遍历，每次保证当前位到最低位组成的数字是递增的
     * 例子：数字 1101 最大单调递增数为 999，从低位向高位遍历，到0时发现前面有一个1>0，这里将后两位置为99，同时向高位“借位”，前两位变成11-1=10；此时num = 1099，继续遍历又发现1>0，重复上述步骤得到结果999。
     */
    public int monotoneIncreasingDigits_1(int N) {
        int res = 0;
        int seed = 1; // 倍数
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if (high > num) { // 高位大于低位，将低位全部置为9，高位数字-1
                res = seed * 10 - 1;
                N -= 1;
            } else {
                res = num * seed + res;
            }
            seed *= 10;
        }
        return res;
    }

    /**
     * 方法二：循环
     * Time: O(logN) N 为输入参数
     * Space: O(logN) N 为输入参数
     * 解题思路：
     * 1. 记录最后一个上升的索引;
     * 2. 当发现下降时，即可基于最后一个上升索引进行计算最大单调递增数字并返回。如：
     * 2456435434334
     * 2456000000000 - 1
     * <p>
     * 13478594876
     * 13478000000 - 1
     */
    public int monotoneIncreasingDigits_2(int N) {
        if (N < 10) return N;
        char[] digits = Integer.toString(N).toCharArray();
        int len = digits.length;
        int lastUpIndex = 0;
        for (int i = 1; i < len; i++) {
            if (digits[i] > digits[i - 1]) {
                lastUpIndex = i;
            } else if (digits[i] < digits[i - 1]) {
                int unit = (int) Math.pow(10, len - lastUpIndex - 1);
                return (N / unit) * unit - 1;
            }
        }
        return N;
    }
}
