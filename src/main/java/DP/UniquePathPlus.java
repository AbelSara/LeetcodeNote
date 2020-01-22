package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 63
 * @grade medium
 */
public class UniquePathPlus {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                dp[i + 1][j + 1] = -obstacleGrid[i][j];
        if (dp[1][1] != -1) dp[1][1] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (dp[i][j] == -1)
                    continue;
                if (dp[i - 1][j] == -1)
                    dp[i][j] += dp[i][j - 1];
                else if (dp[i][j - 1] == -1)
                    dp[i][j] += dp[i - 1][j];
                else if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
        if (dp[m][n] == -1) return 0;
        return dp[m][n];
    }

}
