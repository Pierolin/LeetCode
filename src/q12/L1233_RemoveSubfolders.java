package q12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. 删除子文件夹
 * Remove Sub-Folders from the Filesystem
 * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
 */
public class L1233_RemoveSubfolders {

    /**
     * 方法一：排序
     * TC: O(nl⋅logn)，其中 n 和 l 分别是数组 folder 的长度和文件夹的平均长度。O(nl⋅logn) 为排序需要的时间，后续构造答案需要的时间为 O(nl)，在渐进意义下小于前者。
     * SC: O(l)
     */
    public List<String> removeSubfolders_1(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        String parent = folder[0];
        ans.add(parent);
        for (int i = 1; i < folder.length; i++) {
            String fol = folder[i];
            //if (!(fol + "/").startsWith(parent + "/")) {
            if (!(fol.startsWith(parent) && fol.charAt(parent.length()) == '/')) {
                parent = fol;
                ans.add(parent);
            }
        }
        return ans;
    }

    /**
     * 方法二：字典树
     * TC: O(nl)，其中 n 和 l 分别是数组 folder 的长度和文件夹的平均长度。即为构造字典树和答案需要的时间。
     * SC: O(nl)
     */
    Trie root;
    public List<String> removeSubfolders_2(String[] folder) {
        root = new Trie();
        for (String f : folder) insert(f);
        List<String> ans = new ArrayList<>();
        for (String f : folder) {
            String parent = search(f);
            if (!ans.contains(parent)) ans.add(parent);
        }
        return ans;
    }

    private void insert(String folder) {
        Trie node = root;
        int n = folder.length();
        for (int i = 1; i < n; i++) {
            char c = folder.charAt(i);
            int j = c - 'a';
            if (node.children[j] == null) node.children[j] = new Trie();
            node = node.children[j];
            if (i < n - 1 && folder.charAt(i + 1) == '/') {
                node.isFolder = true;
                i++;
            }
        }
        node.isFolder = true;
        node.isParent = true;
    }

    private String search(String folder) {
        Trie node = root;
        StringBuilder sb = new StringBuilder("/");
        int n = folder.length();
        for (int i = 1; i < n; i++) {
            char c = folder.charAt(i);
            int j = c - 'a';
            sb.append(c);
            if (i < n - 1 && folder.charAt(i + 1) == '/') {
                if (node.children[j].isFolder) {
                    if (node.children[j].isParent) return sb.toString();
                    sb.append("/");
                    i++;
                }
            }
            node = node.children[j];
        }
        return folder;
    }

    class Trie {
        Trie[] children;
        boolean isFolder;
        boolean isParent;
        public Trie() {
            children = new Trie[26];
            isFolder = false;
            isParent = false;
        }
    }
}
