package BinarySearch;

/**
 * @author Honghan Zhu
 * @leetcode 287
 * @grade medium
 */
public class FindTheDuplicatedNumber {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        int len = nums.length - 1;
        while (left < right) {
            int mid = (left + right - 1) / 2;
            int sum = 0;
            for (int i = 0; i <= len; i++) {
                if (nums[i] <= mid && nums[i] >= left)
                    sum += 1;
            }
            if (sum > mid - left + 1)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        new FindTheDuplicatedNumber().findDuplicate(new int[]{1, 4, 4, 2, 4});
    }
}
