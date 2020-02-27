package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 41
 * @grade hard
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean endOfLength =false;
        for(int i = 0; i < len; i++){
            if(nums[i] > len || nums[i] <= 0)
                nums[i] = len + 1;
        }
        for(int i = 0; i < len; i++){
            int idx = Math.abs(nums[i]);
            if(idx == len)
                endOfLength = true;
            else if(idx < len)
                nums[idx] = -Math.abs(nums[idx]);
        }
        int res = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] > 0)
                break;
            else
                res += 1;
        }
        if(res == len && endOfLength)
            res += 1;
        return res;
    }
}
