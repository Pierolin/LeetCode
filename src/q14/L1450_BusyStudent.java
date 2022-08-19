package q14;

/**
 * 1450. 在既定时间做作业的学生人数
 * Number of Students Doing Homework at a Given Time
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class L1450_BusyStudent {

    /**
     * 方法一：遍历枚举
     * TC: O(n)
     * SC: O(1)
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) count++;
        }
        return count;
    }
}
