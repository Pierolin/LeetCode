package q24;

import java.time.LocalDate;

/**
 * 2409. 统计共同度过的日子数
 * 2409. Count Days Spent Together
 * https://leetcode.cn/problems/count-days-spent-together
 */
public class L2409_CountDaysTogether {
    /**
     * 方法一：转化为第几天 + 前缀和
     * TC: O(1)
     * SC: O(1)
     */
    public int countDaysTogether_1(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < days.length; i++) days[i] += days[i - 1];
        int arriveAliceDay = calDayOfYear(days, arriveAlice);
        int leaveAliceDay = calDayOfYear(days, leaveAlice);
        int arriveBobDay = calDayOfYear(days, arriveBob);
        int leaveBobDay = calDayOfYear(days, leaveBob);
        int diff = Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay);
        return Math.max(diff + 1, 0);
    }

    private int calDayOfYear(int[] days, String mmdd) {
        int mm = Integer.parseInt(mmdd.substring(0, 2));
        int dd = Integer.parseInt(mmdd.substring(3));
        return days[mm - 1] + dd;
    }

    /**
     * 方法二：API (LocalDate)
     * TC: O(1)
     * SC: O(1)
     */
    public int countDaysTogether_2(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String YEAR = "2023-";
        LocalDate aliceArr = LocalDate.parse(YEAR + arriveAlice);
        LocalDate bobArr = LocalDate.parse(YEAR + arriveBob);
        LocalDate aliceLev = LocalDate.parse(YEAR + leaveAlice);
        LocalDate bobLev = LocalDate.parse(YEAR + leaveBob);
        LocalDate arrive = aliceArr.isAfter(bobArr) ? aliceArr : bobArr;
        LocalDate leave = aliceLev.isAfter(bobLev) ? bobLev : aliceLev;
        return Math.max(0, (int) (leave.toEpochDay() - arrive.toEpochDay()) + 1);
    }
}
