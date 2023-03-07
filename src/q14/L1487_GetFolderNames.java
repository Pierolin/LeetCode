package q14;

import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * Making File Names Unique
 * https://leetcode.cn/problems/making-file-names-unique/
 */
public class L1487_GetFolderNames {
    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(1)
     */
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] folderNames = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = names[i];
            String fldName = name;
            if (map.containsKey(name)) {
                int k = map.get(name) + 1;
                while (map.containsKey(newName(name, k))) k++;
                map.put(name, k);
                fldName = newName(name, k);
                map.put(fldName, 0);
            } else {
                map.put(name, 0);
            }
            folderNames[i] = fldName;
        }
        return folderNames;
    }

    private String newName(String name, int k) {
        return name + "(" + k + ")";
    }

}
