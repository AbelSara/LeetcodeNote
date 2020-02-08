package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 198
 * @grade easy
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < len; i++) {
            if (i == 2) {
                dp[2] = dp[0] + nums[2];
                continue;
            }
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }
}
