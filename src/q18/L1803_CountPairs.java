package q18;

import java.util.Arrays;

public class L1803_CountPairs {

    /**
     * 方法一：暴力枚举
     * TC: O(n^2)
     * SC: O(1)
     */
    public int countPairs_1(int[] nums, int low, int high) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor >= low && xor <= high) count++;
            }
        }
        return count;
    }


    private Trie root = null;
    private static final int DEPTH = 14;

    /**
     * 方法二：字典树
     * TC: O(nlogC) 其中 n 是 nums 的长度，C 是数组中的元素范围
     * SC: O(nlogC)
     */
    public int countPairs_2(int[] nums, int low, int high) {
        int sum = 0;
        root = new Trie();
        for (int i = 1; i < nums.length; i++) {
            insert(nums[i - 1]);
            sum += get(nums[i], high) - get(nums[i], low - 1);
        }
        return sum;
    }

    private void insert(int num) {
        Trie node = root;
        for (int i = DEPTH; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) node.children[bit] = new Trie();
            node = node.children[bit];
            node.count++;
        }
    }

    private int get(int num, int x) {
        Trie node = root;
        int sum = 0;
        for (int i = DEPTH; i >= 0; i--) {
            int bitn = (num >> i) & 1;
            int bitx = (x >> i) & 1;
            if (bitx == 1) {
                if (node.children[bitn] != null) sum += node.children[bitn].count;
                if (node.children[bitn ^ 1] == null) return sum;
                node = node.children[bitn ^ 1];
            } else {
                if (node.children[bitn] == null) return sum;
                node = node.children[bitn];
            }
        }
        sum += node.count;
        return sum;
    }

}

class Trie {
    Trie[] children;
    int count;

    public Trie() {
        children = new Trie[2];
        count = 0;
    }
}
