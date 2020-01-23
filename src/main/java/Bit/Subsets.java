package Bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 78
 * @grade medium
 */
public class Subsets {
    List<List<Integer>> resList;

    public List<List<Integer>> subsets(int[] nums) {
        resList = new ArrayList<>();
        resList.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            backTrack(nums, i, new LinkedList<>());
        }
        return resList;
    }

    private void backTrack(int nums[], int idx, LinkedList<Integer> tmpList) {
        tmpList.add(nums[idx]);
        resList.add(new LinkedList<>(tmpList));
        for (int i = idx + 1; i < nums.length; i++) {
            backTrack(nums, i, tmpList);
        }
        tmpList.removeLast();
    }
}
