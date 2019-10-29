package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 15
 * @grade medium
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int tar = 0 - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                if (nums[s] + nums[e] == tar) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    result.add(list);
                    int temp = nums[s];
                    while (s < nums.length - 1 && nums[s] == temp) {
                        s++;
                    }
                    temp = nums[e];
                    while (e > 0 && nums[e] == temp) {
                        e--;
                    }
                } else if (nums[s] + nums[e] > tar) {
                    e--;
                } else if (nums[s] + nums[e] < tar) {
                    s++;
                }
            }
        }
        return result;
    }
}
