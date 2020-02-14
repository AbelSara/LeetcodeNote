package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 416
 * @grade medium
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++)
            len += nums[i];
        if (len % 2 == 1) return false;
        len /= 2;
        int[][] dp = new int[nums.length][len + 1];
        if (nums[0] <= len) dp[0][nums[0]] = 1;
        if (nums[0] == len) return true;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] <= len) dp[i][nums[i]] = 1;
            for (int j = 0; j <= len; j++) {
                if (dp[i - 1][j] == 1) {
                    if (!(j + nums[i] > len)) dp[i][j + nums[i]] = 1;
                    dp[i][j] = 1;
                    if (j + nums[i] == len)
                        return true;
                }
            }
        }
        return false;
    }
}
