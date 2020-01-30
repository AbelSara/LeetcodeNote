package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 80
 * @grade medium
 */
public class RemoveDuplicatesFromSortedArrayPlus {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums.length;
        int s = 0, e = 0, n = 0;
        while (n < nums.length) {
            if (n == 0) {
                e++;
                n++;
                continue;
            }
            if (nums[n] == nums[s] && e - s < 2) {
                nums[e++] = nums[n++];
            } else if (nums[n] == nums[s]) {
                int tmp = nums[s];
                s = e;
                while (n < nums.length && tmp == nums[n])
                    n += 1;
                if (n == nums.length) break;
                nums[e++] = nums[n++];
            } else {
                s = e;
                nums[e++] = nums[n++];
            }
        }
        return e;
    }
}
