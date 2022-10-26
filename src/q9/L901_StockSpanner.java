package q9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 901. 股票价格跨度
 * Online Stock Span
 * https://leetcode.cn/problems/online-stock-span/
 */

/**
 * 方法二：单调栈
 * TC: O(n)
 * SC: O(n)
 */
class L901_StockSpanner_2 {
    Deque<int[]> stack;
    int id;

    public L901_StockSpanner_2() {
        stack = new ArrayDeque<>();
        id = -1;
    }

    public int next(int price) {
        id++;
        while (!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
        int lastId = stack.isEmpty() ? -1 : stack.peek()[0];
        stack.push(new int[]{id, price});
        return id - lastId;
    }
}

public class L901_StockSpanner {
    List<int[]> list;

    public L901_StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int n = list.size();
        int count = 1;
        if (n > 0) {
            int i = n - 1;
            while (i >= 0) {
                int[] item = list.get(i);
                int lastPrice = item[0];
                int lastCount = item[1];
                if (lastPrice <= price) {
                    count += lastCount;
                    i -= lastCount;
                } else {
                    break;
                }
            }
        }
        list.add(new int[]{price, count});
        return count;
    }

}