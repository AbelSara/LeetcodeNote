package DP;

import java.util.Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 392
 * @grade easy
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        boolean[] dpPre = new boolean[n + 1];
        Arrays.fill(dpPre, true);
        boolean[] dp = dpPre;
        for(int i = 0; i < m; i++){
            dp = new boolean[n + 1];
            for(int j = i; j < n; j++){
                if(s.charAt(i) == t.charAt(j))
                    dp[j + 1] = dpPre[j];
                else
                    dp[j + 1] = dp[j];
            }
            dpPre = dp;
        }
        return dp[n];
    }
}
