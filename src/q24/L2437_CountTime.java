package q24;

/**
 * 2437. 有效时间的数目
 * Number of Valid Clock Times
 * https://leetcode.cn/problems/number-of-valid-clock-times/description/
 */
public class L2437_CountTime {
    /**
     * 方法一：贪心
     * TC: O(1)
     * SC: O(1)
     */
    public int countTime_1(String time) {
        int hh = 1;
        int mm = 1;
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '?') {
                hh = 24;
            } else {
                if (chars[1] > '3') {
                    hh = 2;
                } else {
                    hh = 3;
                }
            }
        } else {
            if (chars[1] == '?') {
                if (chars[0] == '2') {
                    hh = 4;
                } else {
                    hh = 10;
                }
            }
        }

        if (chars[3] == '?') {
            if (chars[4] == '?') {
                mm = 60;
            } else {
                mm = 6;
            }
        } else {
            if (chars[4] == '?') {
                mm = 10;
            }
        }
        return hh * mm;
    }

    /**
     * 方法三：枚举法优化
     * TC: O(1)
     * SC: O(1)
     */
    public int countTime_2(String time) {
        return count(time.substring(0, 2), 24) * count(time.substring(3), 60);
    }

    private int count(String digits, int range) {
        char first = digits.charAt(0);
        char second = digits.charAt(1);
        int ans = 0;
        for (int i = 0; i < range; i++) {
            if ((first == '?' || first - '0' == i / 10) &&
                    (second == '?' || second - '0' == i % 10)) ans++;
        }
        return ans;
    }
}
