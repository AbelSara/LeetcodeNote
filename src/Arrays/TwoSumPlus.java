package Arrays;

/**
 * Author:Honghan Zhu
 * leetcode:167
 * Grade:easy
 */
public class TwoSumPlus {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                break;
            }
        }
        return new int[]{low+1, high+1};
    }
}
