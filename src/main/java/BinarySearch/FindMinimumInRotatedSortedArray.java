package BinarySearch;

/**
 * @Author Honghan Zhu
 * @leetcode 153
 * @grade medium
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        int s = 0, e = nums.length - 1;
        if (nums[s] < nums[e]) return nums[s];
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid - 1];
            if (nums[mid] > nums[s]) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}
