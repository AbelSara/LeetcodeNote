package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 26
 * @grade easy
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[end])
                nums[++end] = nums[i];
        }
        return end + 1;
    }
}
