package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 90
 * @grade medium
 */
public class SubsetsPlus {
    List<List<Integer>> resList;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            backtrack(nums, i, new ArrayList<>());
        }
        return resList;
    }

    public void backtrack(int[] nums, int idx, List<Integer> list) {
        list.add(nums[idx]);
        resList.add(new ArrayList<>(list));
        for (int i = idx + 1; i < nums.length; i++) {
            if (i > idx + 1 && nums[i] == nums[i - 1])
                continue;
            backtrack(nums, i, list);
        }
        list.remove(list.size() - 1);
    }
}
