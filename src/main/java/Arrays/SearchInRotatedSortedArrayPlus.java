package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 81
 * @grade medium
 */
public class SearchInRotatedSortedArrayPlus {
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[s] == nums[mid]) {
                s++;
                continue;
            }
            if (mid + 1 < nums.length && nums[mid + 1] <= nums[e]) {
                if (target >= nums[mid + 1] && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (mid - 1 >= 0 && target >= nums[s] && target <= nums[mid - 1])
                    e = mid - 1;
                else s = mid + 1;
            }
        }
        return false;
    }
}
