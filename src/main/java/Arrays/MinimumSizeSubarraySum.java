package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 209
 * @grade medium
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            r += 1;
            while (sum >= s) {
                res = Math.min(r - l, res);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
