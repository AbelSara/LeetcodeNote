package DP;

import org.omg.CORBA.MARSHAL;

/**
 * @author Honghan Zhu
 * @leetcode 221
 * @grade medium
 */
public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(res, dp[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if (matrix[i][j] == '1' && matrix[i - 1][j] == '1'
                        && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 2;
                    if (dp[i - 1][j] != dp[i][j - 1])
                        dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i][j]);
                    else if (dp[i - 1][j - 1] <= dp[i - 1][j])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
