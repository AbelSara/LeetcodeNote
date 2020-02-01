package DP;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 89
 * @grade medium
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> resList = new ArrayList<>();
        resList.add(0);
        if (n == 0)
            return resList;
        resList.add(1);
        int thresh = (int) Math.pow(2, n);
        for (int delta = 2; resList.size() < thresh; delta *= 2) {
            for (int i = resList.size() - 1; i >= 0; i--) {
                resList.add(resList.get(i) + delta);
            }
        }

        return resList;
    }
}
