package Arrays;

/**
 * @author: Honghan Zhu
 * @leetcode: 189
 * @grade: easy
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        rotateArray(nums, 0, nums.length - 1 - k);
        rotateArray(nums, nums.length - k, nums.length - 1);
        rotateArray(nums, 0, nums.length - 1);
    }

    private void rotateArray(int nums[], int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
