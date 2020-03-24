package DP;

/**
 * @author Honghan Zhu
 * @面试题 17.16
 * @grade easy
 */
public class TheMasseuse {
    public int massage(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == 1)
                dp[i] = nums[i];
            else if (i == 2) {
                dp[i] = nums[i] + dp[i - 2];
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
