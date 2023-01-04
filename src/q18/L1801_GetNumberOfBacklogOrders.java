package q18;

import java.util.PriorityQueue;

/**
 * 1801. 积压订单中的订单总数
 * Number of Orders in the Backlog
 * https://leetcode.cn/problems/number-of-orders-in-the-backlog/description/
 */
public class L1801_GetNumberOfBacklogOrders {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sells = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                while (amount > 0 && !sells.isEmpty() && sells.peek()[0] <= price) {
                    int[] sell = sells.poll();
                    amount -= sell[1];
                    if (amount < 0) sells.offer(new int[]{sell[0], -amount});
                }
                if (amount > 0) buys.offer(new int[]{price, amount});
            } else {
                while (amount > 0 && !buys.isEmpty() && buys.peek()[0] >= price) {
                    int[] buy = buys.poll();
                    amount -= buy[1];
                    if (amount < 0) buys.offer(new int[]{buy[0], -amount});
                }
                if (amount > 0) sells.offer(new int[]{price, amount});
            }
        }

        double count = 0;
        while (!buys.isEmpty()) count += buys.poll()[1];
        while (!sells.isEmpty()) count += sells.poll()[1];
        //final int MOD = (int) (1e9 + 7);
        return (int) (count % (1e9 + 7));
    }
}
