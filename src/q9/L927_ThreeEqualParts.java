package q9;

/**
 * 927. 三等分
 * Three Equal Parts
 * https://leetcode.cn/problems/three-equal-parts/
 */
public class L927_ThreeEqualParts {

    /**
     * 方法一：计数模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int[] threeEqualParts_2(int[] arr) {
        int n = arr.length;
        int i = -1;
        int j = -1;
        int[] fail = new int[] {-1, -1};

        int ones = 0;
        for (int d : arr) ones += d;
        if (ones == 0) return new int[]{0,2};
        if (ones % 3 > 0) return fail;

        int perOnes = ones / 3;
        int count = 0;
        for (int x = 0; x < n; x++) {
            count += arr[x];
            if (arr[x] == 1) {
                if (count == 1) {
                    i = x;
                } else if (count == perOnes + 1) {
                    j = x;
                }
            }
            if (count > perOnes * 2) {
                if (arr[x] != arr[i++] || arr[x] != arr[j++]) return fail;
            }
        }

        return new int[]{i - 1, j};
    }

    /**
     * 方法一：计数模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int[] threeEqualParts_1(int[] arr) {
        int i = -1;
        int j = -1;

        int[] fail = new int[]{-1, -1};
        int n = arr.length;
        int ones = 0;
        for (int d : arr) ones += d;
        if (ones == 0) return new int[]{0, 2};
        if (ones % 3 > 0) return fail;
        int perOnes = ones / 3;
        int surfixZeros = 0;
        int tempOnes = perOnes;

        for (int x = n - 1; x >= 0; x--) {
            if (arr[x] == 1) {
                if (tempOnes == perOnes) surfixZeros = n - 1 - x;
                tempOnes--;
                if (tempOnes == 0) {
                    tempOnes = perOnes;
                    for (int y = x - 1; y >= 0; y--) {
                        if (j > -1 && arr[y + (n - j)] != arr[y]) return fail;
                        if (arr[y] == 1) {
                            if (tempOnes == perOnes) {
                                j = y + surfixZeros + 1;
                                if (j > x) return fail;
                            }
                            tempOnes--;
                            if (tempOnes == 0) {
                                tempOnes = perOnes;
                                for (int z = y - 1; z >= 0; z--) {
                                    if (i > -1 && arr[z + (n - i - 1)] != arr[z]) return fail;
                                    if (arr[z] == 1) {
                                        if (tempOnes == perOnes) {
                                            i = z + surfixZeros;
                                            if (i >= y) return fail;
                                        }
                                        tempOnes--;
                                        if (tempOnes == 0) break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return new int[]{i, j};
    }
}
