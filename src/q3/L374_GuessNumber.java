package q3;

/**
 * 374. 猜数字大小
 * 374. Guess Number Higher or Lower
 * https://leetcode.cn/problems/guess-number-higher-or-lower/
 **/
public class L374_GuessNumber {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int res = guess(mid);
            if (res == 0) return mid;
            if (res == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     **/
    private int guess(int num) {
        return 0;
    }
}
