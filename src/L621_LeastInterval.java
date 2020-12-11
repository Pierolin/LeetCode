/**
 * 621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 */
public class L621_LeastInterval {

    /**
     * 方法一：桶思想
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1.
     */
    public int leastInterval(char[] tasks, int n) {
        int maxTask = 0; //执行次数最多的那个任务的执行次数
        int maxTaskCount = 0; //执行次数最多的任务数
        int[] counts = new int[26];
        for (char task : tasks) maxTask = Math.max(maxTask, ++counts[task - 'A']);
        for (int count : counts) if (count == maxTask) maxTaskCount++;
        // 如上两个语句也可写成如下一个循环
        /*
        for (char task : tasks) {
            int i = task - 'A';
            counts[i]++;
            if (counts[i] == maxTask) {
                maxTaskCount++;
            } else if (counts[i] > maxTask) {
                maxTask = counts[i];
                maxTaskCount = 1;
            }
        }
        */
        return Math.max((maxTask - 1) * (n + 1) + maxTaskCount, tasks.length);
    }
}
