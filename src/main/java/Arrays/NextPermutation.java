package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 31
 * @grade medium
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean trans = false;
        for (int i = nums.length - 1; i > 0 && !trans; --i) {
            if (nums[i] > nums[i - 1]) {
                int minIdx;
                for (minIdx = nums.length - 1; minIdx > i - 1; --minIdx) {
                    if (nums[minIdx] > nums[i - 1])
                        break;
                }
                int tmp = nums[minIdx];
                nums[minIdx] = nums[i - 1];
                nums[i - 1] = tmp;
                for (int j = i, k = nums.length - 1; j < k; ++j, --k) {
                    tmp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = tmp;
                }
                trans = true;
            }
        }
        if (false == trans) {
            for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
