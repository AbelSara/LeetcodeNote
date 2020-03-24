package Greedy;

import java.util.Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 376
 * @grade medium
 */
public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        boolean[] exist = new boolean[len];
        boolean up = true;
        Arrays.fill(exist, true);
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                while (i < len && nums[i] == nums[i - 1]) {
                    exist[i - 1] = false;
                    i += 1;
                }
                if (i >= len)
                    break;
                up = nums[i] - nums[i - 1] > 0 ? true : false;
                continue;
            }
            if (up && nums[i] >= nums[i - 1]) {
                exist[i - 1] = false;
            } else if (!up && nums[i] <= nums[i - 1]) {
                exist[i - 1] = false;
            } else
                up = up ? false : true;
        }
        int res = 0;
        for (int i = 0; i < len; i++)
            res += exist[i] ? 1 : 0;
        return res;
    }
}
