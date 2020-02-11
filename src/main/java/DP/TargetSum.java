package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 494;
 * @grade medium
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000) return 0;
        int[][] dp = new int[nums.length][2001];
        int base = 1000;
        dp[0][nums[0] + base] += 1;
        dp[0][-nums[0] + base] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= base * 2; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][S + base];
    }
}
