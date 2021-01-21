package q0;

/**
 * 9. 回文数 (Palindrome Number
 * https://leetcode-cn.com/problems/palindrome-number/)
 */
public class L9_IsPalindrome {
    /**
     * 方法一：反转后半数字
     * Time: O(logn)
     * Space: O(1)
     * 解题思路：
     * 1. 反转后半数字;
     * 2. 反转后半等于前半即为回文;
     * 3. 特别注意当输入数字位数为奇数位时要进行除 10 处理。
     */
    public boolean isPalindrome_1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNum || x == (reverseNum / 10);
    }

    /**
     * 方法二：首尾数字比较
     * Time: O(logn)
     * Space: O(1)
     * 解题思路：
     * 1. 先算出最高位作为除数;
     * 2. 获取首数尾数并比较是否相等，不等即结束;
     * 3. 去掉首数和尾数;
     * 4. 循环上面 3 步骤。
     */
    public boolean isPalindrome_2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = x % div / 10;
            div = div / 100;
        }

        return true;
    }

    /**
     * 方法三：字符串反转
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 把数字转为字符串，然后反转字符串再与字符串比较是否相等。
     */
    public boolean isPalindrome_3(int x) {
        String str = x + "";
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
