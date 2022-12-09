package q17;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * Find Nearest Point That Has the Same X or Y Coordinate
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
 */
public class L1779_NearestValidPoint {
    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int nearest = -1;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];
            if (px == x || py == y) {
                int distance = Math.abs(px - x) + Math.abs(py - y);
                if (distance < smallest) {
                    smallest = distance;
                    nearest = i;
                }
            }
        }
        return nearest;
    }
}
