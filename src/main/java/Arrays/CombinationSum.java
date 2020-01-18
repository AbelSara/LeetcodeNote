package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 39
 * @grade medium
 */
public class CombinationSum {
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; ++i)
            combination(candidates, target, i, 0, new ArrayList<>());
        return resList;
    }

    private void combination(int[] candidates, int target, int index, int sum, List<Integer> list) {
        if (index >= candidates.length || sum >= target)
            return;
        list.add(candidates[index]);
        sum += candidates[index];
        if (sum == target) {
            resList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; ++i)
            combination(candidates, target, i, sum, list);
        list.remove(list.size() - 1);
    }
}
