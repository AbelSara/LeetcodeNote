package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 34
 * @grade medium
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[]{-1, -1};
        if (nums.length == 0)
            return res;
        res[0] = foundMinOrMax(nums, target, 0);
        res[1] = foundMinOrMax(nums, target, 1);
        return res;
    }

    //0找左侧，1找右侧
    public int foundMinOrMax(int nums[], int target, int template) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                if (template == 0)
                    r = mid-1;
                else if (template == 1)
                    l = mid+1;
            }
        }
        return res;
    }

}
