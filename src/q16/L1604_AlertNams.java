package q16;

import java.util.*;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * Alert Using Same Key-Card Three or More Times in a One Hour Period
 * https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 */
public class L1604_AlertNams {

    /**
     * 方法一：列表双重排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public List<String> alertNames_1(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        List<String[]> keyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            keyList.add(new String[]{keyName[i], keyTime[i]});
        }
        keyList.sort((a, b) -> (a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0])));

        String pre2Name = keyList.get(0)[0];
        int pre2Time = toMinute(keyList.get(0)[1]);
        String pre1Name = keyList.get(1)[0];
        int pre1Time = toMinute(keyList.get(1)[1]);
        List<String> ansList = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            String currName = keyList.get(i)[0];
            int currTime = toMinute(keyList.get(i)[1]);
            if (currName.equals(pre2Name) && !ansList.contains(currName) && Math.abs(currTime - pre2Time) <= 60) {
                ansList.add(currName);
            }
            pre2Name = pre1Name;
            pre2Time = pre1Time;
            pre1Name = currName;
            pre1Time = currTime;
        }
        return ansList;
    }

    /**
     * 方法一：哈希表 + 排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public List<String> alertNames_2(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int time = toMinute(keyTime[i]);
            map.computeIfAbsent(name, k -> new ArrayList<>()).add(time);
        }
        List<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            int n = times.size();
            if (n > 2) {
                Collections.sort(times);
                for (int i = 2; i < n; i++) {
                    if (times.get(i) - times.get(i - 2) <= 60) {
                        list.add(name);
                        break;
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    private int toMinute(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
