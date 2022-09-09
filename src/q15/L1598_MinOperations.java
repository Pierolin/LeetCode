package q15;

/**
 * 1598. 文件夹操作日志搜集器
 * Crawler Log Folder
 * https://leetcode.cn/problems/crawler-log-folder/
 */
public class L1598_MinOperations {
    /**
     * 方法一：直接模拟
     * TC: O(n)
     * SC: 0(1)
     */
    public int minOperations(String[] logs) {
        int min = 0;
        for (String log : logs) {
            if (log.equals("../")) min = Math.max(0, --min);
            else if (!log.equals("./")) min++;
        }
        return min;
    }
}
