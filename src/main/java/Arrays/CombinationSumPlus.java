package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 40
 * @grade medium
 */
public class CombinationSumPlus {
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            combination(candidates, i, target, 0, new ArrayList<>());
        }
        return resList;
    }

    private void combination(int[] candidates, int index, int target, int sum, List<Integer> tmpList) {
        if (index >= candidates.length || sum >= target)
            return;
        sum += candidates[index];
        tmpList.add(candidates[index]);
        if (sum == target) {
            resList.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            if (i > index + 1 && candidates[i] == candidates[i - 1])
                continue;
            else if (sum > target)
                break;
            combination(candidates, i, target, sum, tmpList);
        }
        tmpList.remove(tmpList.size() - 1);
    }
}
