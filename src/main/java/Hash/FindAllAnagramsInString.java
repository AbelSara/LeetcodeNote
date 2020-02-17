package Hash;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 438
 * @grade meidum
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int l = 0, r = 0;
        int len = s.length();
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            int times = dict.getOrDefault(p.charAt(i), 0) + 1;
            dict.put(p.charAt(i), times);
        }
        int matches = 0;
        Map<Character, Integer> dynamicDict = new HashMap<>();
        while (r < len) {
            int times = dynamicDict.getOrDefault(s.charAt(r), 0) + 1;
            dynamicDict.put(s.charAt(r), times);
            if (times == dict.getOrDefault(s.charAt(r), 0))
                matches += 1;
            while (matches == dict.size()) {
                if (r - l + 1 == p.length()) {
                    res.add(l);
                }
                times = dynamicDict.get(s.charAt(l)) - 1;
                if (times == 0)
                    dynamicDict.remove(s.charAt(l));
                else
                    dynamicDict.put(s.charAt(l), times);
                if (dict.containsKey(s.charAt(l)) && times < dict.get(s.charAt(l)))
                    matches -= 1;
                l += 1;
            }
            r += 1;
        }
        return res;
    }
}