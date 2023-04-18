package q10;

/**
 * 1041. 困于环中的机器人
 * Robot Bounded In Circle
 * https://leetcode.cn/problems/robot-bounded-in-circle
 */
public class L1041_IsRobotBounded {
    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isRobotBounded_1(String instructions) {
        char d = 'N';
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                if (d == 'N') d = 'W';
                else if (d == 'W') d = 'S';
                else if (d == 'S') d = 'E';
                else d = 'N';
            } else if (c == 'R') {
                if (d == 'N') d = 'E';
                else if (d == 'E') d = 'S';
                else if (d == 'S') d = 'W';
                else d = 'N';
            } else {
                if (d == 'N') y++;
                else if (d == 'W') x--;
                else if (d == 'S') y--;
                else x++;
            }
        }
        return d != 'N' || (x == 0 && y == 0);
    }

    /**
     * 方法二：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isRobotBounded_2(String instructions) {
        int d = 0;
        int[] steps = new int[4];
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                d = (d + 1) % 4;
            } else if (c == 'R') {
                d = (d + 3) % 4;
            } else {
                steps[d]++;
            }
        }
        return (steps[0] == steps[2] && steps[1] == steps[3]) || d != 0;
    }

    /**
     * 方法三：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isRobotBounded_3(String instructions) {
        int d = 0;
        int x = 0;
        int y = 0;
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                d = (d + 1) % 4;
            } else if (c == 'R') {
                d = (d + 3) % 4;
            } else {
                x += dirs[d][0];
                y += dirs[d][1];
            }
        }
        return (x == 0 && y == 0) || d != 0;
    }
}
