package Arrays;

/**
 * @author: Honghan Zhu
 * @leetcode: 53
 * @grade: easy
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > result) {
                result = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}
