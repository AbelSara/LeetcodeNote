package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 91
 * @grade medium
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '0') return 0;
                dp[i] = 1;
                continue;
            }
            int val = Integer.valueOf(s.substring(i - 1, i + 1));
            if (s.charAt(i) != '0') {
                if (val >= 10 && val <= 26)
                    dp[i] = i - 2 >= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1] + 1;
                else dp[i] = dp[i - 1];
            } else if (s.charAt(i) == '0') {
                if (val < 1 || val > 26)
                    return 0;
                else
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
