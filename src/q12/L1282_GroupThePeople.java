package q12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1282_GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        if (groupSizes == null || groupSizes.length == 0) return groups;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            /*
            List<Integer> persons = map.getOrDefault(size, new ArrayList<>());
            persons.add(i);
            map.put(size, persons);
            */
            map.putIfAbsent(size, new ArrayList<Integer>());
            map.get(size).add(i);
        }

        for (int size : map.keySet()) {
            List<Integer> persons = map.get(size);
            for (int i = 0; i < persons.size(); i = i + size) {
                List<Integer> group = new ArrayList<>();
                for (int j = i; j < i + size; j++) group.add(persons.get(j));
                groups.add(group);
            }
        }

        return groups;
    }
}
