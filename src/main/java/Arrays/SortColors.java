package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 75
 * @grade medium
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int color : nums)
            colors[color]++;
        for (int i = 0, idx = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
}
