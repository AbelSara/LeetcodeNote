package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 213
 * @grade medium
 */
public class HouseRobberPlus {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }

    public int robber(int[] nums, int s, int e) {
        if (s == e) return nums[s];
        int len = e + 1 - s;
        int[] dp = new int[nums.length];
        dp[s] = nums[s];
        dp[s + 1] = nums[s + 1];
        for (int i = s + 2; i <= len; i++) {
            if (i == s + 2) {
                dp[s + 2] = dp[s] + nums[i];
                continue;
            }
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[e], dp[e - 1]);
    }

    public static void main(String[] args) {
        new HouseRobberPlus().rob(new int[]{1, 2, 1, 1});
    }
}
