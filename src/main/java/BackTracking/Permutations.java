package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 46
 * @grade medium
 */
public class Permutations {
    List<List<Integer>> resList;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        resList = new ArrayList<>();
        visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            backTracking(nums, i, new ArrayList<>());
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
            if (!visited[i])
                backTracking(nums, i, tmpList);
        }
        visited[index] = false;
        tmpList.remove(tmpList.size() - 1);
    }
}
