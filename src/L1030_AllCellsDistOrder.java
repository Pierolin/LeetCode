import java.util.*;

/**
 * 1030. 距离顺序排列矩阵单元格
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */
public class L1030_AllCellsDistOrder {
    public int[][] allCellsDistOrder_1(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                result[r * C + c] = new int[]{r, c};
            }
        }
        /*
        Arrays.sort(result, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });
        */
        Arrays.sort(result, (o1, o2) -> ((Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0))));
        return result;
    }

    /**
     * 方法二：哈希表
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 使用哈希表，距离作键值，HashMap 将自动按键值排序
     */
    public int[][] allCellsDistOrder_2(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> distances = new HashMap<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int distance = Math.abs(r - r0) + Math.abs(c - c0);
                List<int[]> cells = distances.getOrDefault(distance, new ArrayList<int[]>());
                cells.add(new int[]{r, c});
                distances.put(distance, cells);
            }
        }

        int[][] result = new int[R * C][2];
        int i = 0;
        for (int key : distances.keySet()) {
            for (int[] cell : distances.get(key)) result[i++] = cell;
        }
        return result;
    }

    /**
     * 方法三：BFS
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 使用双端队列存储距离一样的节点，使用 HashSet 存储访问过的节点
     */
    public int[][] allCellsDistOrder_3(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];

        Deque<int[]> cells = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        cells.push(new int[]{r0, c0});
        visited.add(r0 + "," + c0);

        int i = 0;
        while (!cells.isEmpty()) {
            int size = cells.size();
            //System.out.println("size: " + size);
            for (int j = 0; j < size; j++) {
                int[] curr = cells.poll();
                //System.out.println(i);
                result[i++] = curr;
                int r = curr[0];
                int c = curr[1];

                // up
                if (r > 0) {
                    int[] up = new int[]{r - 1, c};
                    if (!visited.contains(up[0] + "," + up[1])) {
                        cells.add(up);
                        visited.add(up[0] + "," + up[1]);
                    }
                }
                // down
                if (r < R - 1) {
                    int[] down = new int[]{r + 1, c};
                    if (!visited.contains(down[0] + "," + down[1])) {
                        cells.add(down);
                        visited.add(down[0] + "," + down[1]);
                    }

                }
                // left
                if (c > 0) {
                    int[] left = new int[]{r, c - 1};
                    if (!visited.contains(left[0] + "," + left[1])) {
                        cells.add(left);
                        visited.add(left[0] + "," + left[1]);
                    }
                }
                // right
                if (c < C - 1) {
                    int[] right = new int[]{r, c + 1};
                    if (!visited.contains(right[0] + "," + right[1])) {
                        cells.add(right);
                        visited.add(right[0] + "," + right[1]);
                    }
                }
            }
        }

        return result;


    }
}
