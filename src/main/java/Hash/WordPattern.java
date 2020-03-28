package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Honghan Zhu
 * @leetcode 290
 * @grade easy
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> dict = new HashMap<>();
        Map<String, Character> reverseDict = new HashMap<>();
        String[] strs = str.split(" ");
        if(strs.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!dict.containsKey(pattern.charAt(i)) && !reverseDict.containsKey(strs[i])) {
                dict.put(pattern.charAt(i), strs[i]);
                reverseDict.put(strs[i], pattern.charAt(i));
            } else if (dict.containsKey(pattern.charAt(i)) && reverseDict.containsKey(strs[i])) {
                if(!dict.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
