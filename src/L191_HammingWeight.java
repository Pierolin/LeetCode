/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class L191_HammingWeight {
    /**
     * 方法一：位与法
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. n & (n - 1) 给最后一个 1 清 0;
     */
    public int hammingWeight_1(int n) {
        int count = 0;
        while (n != 0) {
            System.out.println(Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(n - 1));
            System.out.println("-----------------------------");
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 方法二：除 2 短除法
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 根据十进制转二制位的短除法
     */
    public int hammingWeight_2(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n = n / 2;
        }
        return count;
    }

    /**
     * 方法三：位与 + 位移
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 位与判断最后 1 位是否为 1;
     * 2. 向右位移删除最低位。
     */
    public int hammingWeight_3(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    /**
     * 方法四：位或 + 位移
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 位或判断最后 1 位是否为 1;
     * 2. 向右位移删除最低位。
     */
    public int hammingWeight_4(int n) {
        int count = 0;
        while (n > 0) {
            if ((n | 1) == n) count++;
            n = n >> 1;
        }
        return count;
    }

    /**
     * 方法五：循环
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 转为二进制字符串;
     * 2. 逐一判断每一字符是否为 '1'.
     */
    public int hammingWeight_5(int n) {
        int count = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        L191_HammingWeight hammingWeight = new L191_HammingWeight();
        System.out.println(hammingWeight.hammingWeight_1(152));


    }
}
