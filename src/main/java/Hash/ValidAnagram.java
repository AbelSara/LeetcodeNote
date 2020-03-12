package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Honghan Zhu
 * @leetcode 242
 * @grade easy
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() < t.length()){
            String tmp = s;
            s = t;
            t = tmp;
        }
        Map<Character, Integer> dict = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int times = dict.getOrDefault(s.charAt(i), 0) + 1;
            dict.put(s.charAt(i), times);
        }
        int matches = 0;
        Map<Character, Integer> curDict = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int times = curDict.getOrDefault(t.charAt(i), 0) + 1;
            if(dict.containsKey(t.charAt(i)) && times == dict.get(t.charAt(i)))
                matches += 1;
            curDict.put(t.charAt(i), times);
        }
        return matches == dict.size();
    }
}
