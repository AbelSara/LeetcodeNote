package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 229
 * @grade medium
 */
public class MaijorElementPlus {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int count1 = 0, count2 = 0;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if (num1 == num) {
                count1++;
                continue;
            }
            if (num2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                num1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                num2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        int need = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
        }
        if (count1 > need)
            res.add(num1);
        if (count2 > need)
            res.add(num2);
        return res;
    }
}
