package DP;

/**
 * @Author Honghan Zhu
 * @leetcode 55
 * @grade medium
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (i + nums[i] >= lastIdx)
                lastIdx = i;
        return lastIdx == 0 ? true : false;
    }

}
