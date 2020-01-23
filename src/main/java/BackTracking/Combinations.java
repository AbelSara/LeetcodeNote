package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 77
 * @grade medium
 */
public class Combinations {
    List<List<Integer>> resList;

    public List<List<Integer>> combine(int n, int k) {
        resList = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; i++)
            backTrack(i, n, k, new LinkedList<>());
        return resList;
    }

    private void backTrack(int self, int n, int k, LinkedList<Integer> tmpList) {
        tmpList.add(self);
        if (tmpList.size() == k) {
            resList.add(new LinkedList<>(tmpList));
            tmpList.removeLast();
            return;
        }
        for (int i = self; i < n; i++) {
            backTrack(i + 1, n, k, tmpList);
        }
        tmpList.removeLast();
    }
}
