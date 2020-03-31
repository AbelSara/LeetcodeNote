package StringPack;

import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 524
 * @grade medium
 */
public class LongestWordDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubstr(s, str) && (str.length() > res.length() ||
                    (str.length() == res.length() && str.compareTo(res) < 0)))
                res = str;
        }
        return res;
    }

    private boolean isSubstr(String s, String p) {
        int i, j;
        for (i = 0, j = 0; i < s.length() && j < p.length(); i++) {
            if (s.charAt(i) == p.charAt(j))
                j++;
        }
        return j == p.length();
    }
}
