package DP;

import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 120
 * @grade medium
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + tmp.get(j);
            }
        }
        return dp[0][0];
    }
}
