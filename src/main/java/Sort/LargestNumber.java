package Sort;

import java.util.Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 179
 * @grade medium
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        if (nums.length == 0) return "0";
        Arrays.sort(strs, (o1, o2) -> {
            long val = Long.valueOf(o1 + o2) - Long.valueOf(o2 + o1);
            return val > 0 ? -1 : 1;
        });
        StringBuilder builder = new StringBuilder();
        for (String s : strs)
            builder.append(s);
        return builder.toString();
    }
}
