package q17;

public class L1780_CheckPowersOfThree {

    /**
     * 方法三：三进制 + 递归法
     * TC: O(logn)
     * SC: O(1)
     */
    public boolean checkPowersOfThree_3(int n) {
        return n == 0 || (n % 3 != 2 && checkPowersOfThree_3(n / 3));
    }

    /**
     * 方法二：三进制 + 迭代法
     * TC: O(logn)
     * SC: O(1)
     */
    public boolean checkPowersOfThree_2(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }

    /**
     * 方法一：模拟 + 递归法
     * TC: O(logn)
     * SC: O(1)
     */
    public boolean checkPowersOfThree_1(int n) {
        if (n == 1) return true;
        if (n % 3 == 0) return checkPowersOfThree_1(n / 3);
        if (n % 3 == 1) return checkPowersOfThree_1((n - 1) / 3);
        return false;
    }
}
