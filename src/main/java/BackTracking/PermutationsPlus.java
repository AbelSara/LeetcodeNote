package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 47
 * @grade medium
 */
public class PermutationsPlus {
    List<List<Integer>> resList;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        resList = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            backTracking(nums, i, new ArrayList<>());
        }
        return resList;
    }

    private void backTracking(int[] nums, int index, List<Integer> tmpList) {
        visited[index] = true;
        tmpList.add(nums[index]);
        if (tmpList.size() == nums.length) {
            resList.add(new ArrayList<>(tmpList));
            visited[index] = false;
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            if (!visited[i])
                backTracking(nums, i, tmpList);
        }
        visited[index] = false;
        tmpList.remove(tmpList.size() - 1);
    }
}
