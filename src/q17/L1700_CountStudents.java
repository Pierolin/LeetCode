package q17;

public class L1700_CountStudents {
    /**
     * 方法一：数组计数 + 异或
     * TC: O(n)
     * SC: O(1)
     */
    public int countStudents_2(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int s : students) counts[s]++;
        for (int s : sandwiches) if (counts[s]-- == 0) return counts[s ^ 1];
        return 0;
    }

    /**
     * 方法一：数组计数
     * TC: O(n)
     * SC: O(1)
     */
    public int countStudents_1(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int[] counts = new int[2];
        for (int s : students) counts[s]++;
        for (int i = 0; i < n; i++) {
            if (counts[sandwiches[i]]-- == 0) return n - i;
        }
        return 0;
    }
}
