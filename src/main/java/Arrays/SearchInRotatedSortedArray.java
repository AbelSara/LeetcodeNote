package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 33
 * @grade medium
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int res = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target <= nums[mid])
                    r = mid - 1;
                else l = mid + 1;
            } else if (nums[mid] <= nums[r]) {
                if (target <= nums[r] && target >= nums[mid])
                    l = mid + 1;
                else r = mid - 1;
            }
        }
        return res;
    }
}
