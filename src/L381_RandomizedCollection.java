import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class L381_RandomizedCollection {
    List<Integer> list;
    HashMap<Integer, List<Integer>> map;

    /**
     * Initialize your data structure here.
     */
    public L381_RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, List<Integer>>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        int newIndex = list.size() - 1;
        if (map.containsKey(val)) {
            List<Integer> indexs = map.get(val);
            indexs.add(newIndex);
            map.put(val, indexs);
            return false;
        } else {
            List<Integer> indexs = new ArrayList<>();
            indexs.add(newIndex);
            map.put(val, indexs);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            List<Integer> indexs = map.get(val);
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            if (indexs.size() == 1) {
                int index = indexs.get(0);
                list.set(index, lastVal);
                list.remove(lastIndex);
                updateMap(map, lastVal, lastIndex, index);
                map.remove(val);
            } else {
                int index = indexs.get(indexs.size() - 1);
                list.set(index, lastVal);
                list.remove(lastIndex);
                indexs.remove(indexs.size() - 1);
                map.put(val, indexs);
                updateMap(map, lastVal, lastIndex, index);
            }
            return true;
        } else {
            return false;
        }

    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    private void updateMap(HashMap<Integer, List<Integer>> map, int lastVal, int lastIndex, int newIndex) {
        List<Integer> indexs = map.get(lastVal);
        for (int i = 0; i < indexs.size(); i++) {
            if (indexs.get(i) == lastIndex) {
                indexs.set(i, newIndex);
                return;
            }
        }
    }
}
