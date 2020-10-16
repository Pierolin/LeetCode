import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class L977_SortedSquares {
    public int[] sortedSquares_1(int[] A) {
        int[] result = new int[A.length];
        int l = 0;
        int r = A.length - 1;
        int i = A.length - 1;
        while (l <= r) {
            int ll = A[l] * A[l];
            int rr = A[r] * A[r];
            if (ll >= rr) {
                result[i--] = ll;
                l++;
            } else {
                result[i--] = rr;
                r--;
            }
        }
        return result;
    }

    public int[] sortedSquares_2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares_3(int[] A) {
        return Arrays.stream(A).map(x -> x * x).sorted().toArray();
    }
}
