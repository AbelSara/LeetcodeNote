package DP;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 140
 * @grade hard
 */
public class WordBreakPlus {
    List<String> resList;

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        resList = new LinkedList<>();
        int maxLen = -1;
        for (String str : dict) {
            if (str.length() > maxLen)
                maxLen = str.length();
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[s.length()])
            backtrack(s, 0, maxLen, dict, dp, "");
        return resList;
    }

    private void backtrack(String s, int start, int maxLen, Set<String> dict, boolean[] dp, String curStr) {
        if (start == s.length())
            resList.add(curStr);
        for (int i = start + 1; i <= s.length() && i <= start + maxLen; i++) {
            String val = s.substring(start, i);
            if (dp[i] && dict.contains(val)) {
                if (!curStr.equals(""))
                    backtrack(s, i, maxLen, dict, dp, curStr + " " + val);
                else
                    backtrack(s, i, maxLen, dict, dp, curStr + val);
            }
        }
    }
}
