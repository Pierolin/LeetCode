package q8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 895. 最大频率栈
 * Maximum Frequency Stack
 * https://leetcode.cn/problems/maximum-frequency-stack/description/
 */
public class L895_FreqStack {
    /**
     * 方法一：哈希表和栈
     * TC: O(1)
     * SC: O(n)
     */
    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> stack;
    private int maxFreq;

    public L895_FreqStack() {
        freq = new HashMap<Integer, Integer>();
        stack = new HashMap<Integer, Deque<Integer>>();
        maxFreq = 0;
    }

    public void push(int val) {
        int count = freq.getOrDefault(val, 0) + 1;
        freq.put(val, count);
        stack.putIfAbsent(count, new ArrayDeque<Integer>());
        stack.get(count).push(val);
        maxFreq = Math.max(maxFreq, count);
    }

    public int pop() {
        Deque<Integer> nums = stack.get(maxFreq);
        int val = nums.peek();
        freq.put(val, freq.get(val) - 1);
        nums.pop();
        if (nums.isEmpty()) maxFreq--;
        return val;
    }
}
