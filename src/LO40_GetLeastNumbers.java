import java.util.Arrays;

public class LO40_GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] getLeastNumbers_2(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            res[i] = arr[minIndex];
        }
        return res;
    }
}
