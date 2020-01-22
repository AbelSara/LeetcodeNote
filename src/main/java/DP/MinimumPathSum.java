package DP;


import java.util.Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 64
 * @grade medium
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= m; i++)
            dp[i][0] = Integer.MAX_VALUE;
        dp[0][1] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
