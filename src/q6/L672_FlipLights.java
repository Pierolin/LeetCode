package q6;

/**
 * 672. 灯泡开关 Ⅱ
 * Bulb Switcher II
 * https://leetcode.cn/problems/bulb-switcher-ii/
 */
public class L672_FlipLights {
    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) {
            if (presses == 1) return 3;
            return 4;
        } else {
            if (presses == 1) return 4;
            if (presses == 2) return 7;
            return 8;
        }

    }
}
