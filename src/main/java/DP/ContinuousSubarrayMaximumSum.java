package DP;

/**
 * @author Honghan Zhu
 * @面试题 42
 * @grade easy
 */
public class ContinuousSubarrayMaximumSum {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(total, max);
            if (total < 0)
                total = 0;
        }
        return max;
    }
}
