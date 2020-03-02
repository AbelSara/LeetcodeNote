package BinarySearch;

/**
 * @author Honghan Zhu
 * @leetcode 162
 * @grade medium
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) >> 1;
            if (nums[mid] > nums[mid + 1])
                e = mid;
            else
                s = mid + 1;
        }
        return s;
    }
}
