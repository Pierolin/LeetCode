package q8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * Subdomain Visit Count
 * https://leetcode.cn/problems/subdomain-visit-count/
 */
public class L811_SubdomainVisits {
    /**
     * 方法一：哈希法
     * TC:
     * SC:
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");
            String domain = arr[1];
            int count = Integer.parseInt(arr[0]);
            map.put(domain, map.getOrDefault(domain, 0) + count);
            int i = -1;
            while (true) {
                i = domain.indexOf(".", i + 1);
                if (i == - 1) break;
                String subdomain = domain.substring(i + 1);
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }

        return list;
    }






}
