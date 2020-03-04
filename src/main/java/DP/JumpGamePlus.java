package DP;

import java.util.Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 45
 * @grade hard
 */
public class JumpGamePlus {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, len + 1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int step = nums[i];
            if (i + step >= len)
                step -= i + step - len + 1;
            for (int j = step; j >= 0 && dp[i + j] > dp[i] + 1; j--) {
                dp[i + j] = dp[i] + 1;
                if (i + j == len - 1)
                    return dp[i + j];
            }
        }
        return dp[len - 1];
    }
}
