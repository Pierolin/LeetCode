package q24;

/**
 * 2446. 判断两个事件是否存在冲突
 * Determine if Two Events Have Conflict
 * https://leetcode.cn/problems/determine-if-two-events-have-conflict/description/
 */
public class L2446_HaveConflict {
    /**
     * 方法一：compareTo 方法
     * TC:
     * SC:
     */
    public boolean haveConflict_1(String[] event1, String[] event2) {
        if (event2[0].compareTo(event1[0]) >= 0 && event2[0].compareTo(event1[1]) <= 0) return true;
        if (event1[0].compareTo(event2[0]) >= 0 && event1[0].compareTo(event2[1]) <= 0) return true;
        return false;
    }

    /**
     * 方法一：转化为分钟数
     * TC:
     * SC:
     */
    public boolean haveConflict_2(String[] event1, String[] event2) {
        int event1Start = toMinutes(event1[0]);
        int event1End = toMinutes(event1[1]);
        int event2Start = toMinutes(event2[0]);
        int event2End = toMinutes(event2[1]);

        return  !(event2Start > event1End || event2End < event1Start);
    }

    private int toMinutes(String time) {
        int i = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, i));
        int minutes = Integer.parseInt(time.substring(i + 1));
        minutes += hours * 60;
        return minutes;
    }
}
