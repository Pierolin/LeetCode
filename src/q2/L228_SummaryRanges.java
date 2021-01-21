package q2;

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {
    /**
     * 方法一: 使用 BufferBuilder
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 使用 BufferBuilder;
     */
    public List<String> summaryRanges_1(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                sb.append(nums[i]);
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                    sb.append("->");
                }
            }
        }
        sb.append(nums[len - 1]);
        list.add(sb.toString());
        return list;
    }

    /**
     * 方法一: 遍历比较字符串拼接
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 如果数组只有 1 个元素直接返回;
     * 2. 遍历到最后时要做特别判断。
     */
    public List<String> summaryRanges_2(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null) return list;

        int len = nums.length;
        if (len == 0) return list;
        if (len == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int start = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (nums[i - 1] == start) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
            if (i == len - 1) {
                if (nums[i] == start) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i]);
                }
            }
        }

        return list;
    }
}
