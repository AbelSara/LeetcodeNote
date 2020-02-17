package Arrays;

/**
 * @author  Honghan Zhu
 * @leetcode 283
 * @grade easy
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int s = 0, e = 0;
        while(e < nums.length){
            if(nums[e] == 0){
                e += 1;
                continue;
            }
            nums[s++] = nums[e++];
        }
        while(s<nums.length)
            nums[s++] = 0;
    }
}
