package q7;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/submissions/
 */
public class L735_AsteroidCollision {
    /**
     *方法一：栈模拟
     * TC: O(n)
     * SC: O(n)
     */
    public int[] asteroidCollision_2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean isLived = true;
            while (aster < 0 &&  !stack.isEmpty() && stack.peek() >0 && isLived) {
                isLived = -aster > stack.peek();
                if (-aster >= stack.peek()) stack.pop();
            }
            if (isLived) stack.push(aster);
        }

        int size = stack.size();
        int[] ans = new int[size];
        while (size > 0) ans[--size] = stack.pop();
        return ans;
    }

    /**
     *方法一：暴力枚举
     * TC: O(n^2)
     * SC: O(n)
     */
    public int[] asteroidCollision_1(int[] asteroids) {
        int len = asteroids.length;
        if (len == 0) return new int[0];

        for (int i = 1; i < len; i++) {
            if (asteroids[i] < 0) {
                for (int j = i - 1; j > -1; j--) {
                    if (asteroids[j] < 0) break;
                    if (-asteroids[i] > asteroids[j]) {
                        asteroids[j] = 0;
                    } else if (-asteroids[i] == asteroids[j]) {
                        asteroids[j] = 0;
                        asteroids[i] = 0;
                        break;
                    } else {
                        asteroids[i] = 0;
                        break;
                    }
                }
            }
        }

        int size = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) size++;
        }

        int[] result = new int[size];
        int i = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) result[i++] = asteroid;
        }

        return result;
    }
}
