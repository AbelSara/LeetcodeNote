package StringPack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Honghan Zhu
 * @leetcode 49
 * @grade medium
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmpArray = str.toCharArray();
            Arrays.sort(tmpArray);
            String tmpStr = String.valueOf(tmpArray);
            if (map.containsKey(tmpStr)) {
                map.get(tmpStr).add(String.valueOf(str));
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmpStr, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
