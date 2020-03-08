package StringPack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Honghan Zhu
 * @leetcode 76
 * @grade hard
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int times = dict.getOrDefault(t.charAt(i), 0) + 1;
            dict.put(t.charAt(i), times);
        }
        int l = 0, r = 0;
        Map<Character, Integer> curDict = new HashMap<>();
        int matches = 0;
        int needMatch = dict.size();
        int len = s.length() + 1;
        String res = "";
        while (r < s.length()) {
            int times = curDict.getOrDefault(s.charAt(r), 0) + 1;
            curDict.put(s.charAt(r), times);
            if (times == dict.getOrDefault(s.charAt(r), 0))
                matches += 1;
            r += 1;
            while (matches == needMatch) {
                if (r - l < len) {
                    res = s.substring(l, r);
                    len = r - l;
                }
                if (curDict.containsKey(s.charAt(l))) {
                    times = curDict.get(s.charAt(l)) - 1;
                    curDict.put(s.charAt(l), times);
                }
                if (dict.containsKey(s.charAt(l)) && times < dict.get(s.charAt(l))) {
                    matches -= 1;
                }
                l += 1;
            }
        }
        return res;
    }
}
