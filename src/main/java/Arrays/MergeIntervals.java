package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

/**
 * @Author Honghan Zhu
 * @leetcode 56
 * @grade medium
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; ++i) {
            int[] tmpInterval = intervals[i];
            if (i < intervals.length - 1) {
                int[] nextInterval = intervals[i + 1];
                if (nextInterval[0] <= tmpInterval[1]) {
                    nextInterval[0] = tmpInterval[0];
                    nextInterval[1] = tmpInterval[1] > nextInterval[1] ? tmpInterval[1] : nextInterval[1];
                } else
                    resList.add(tmpInterval);
            } else {
                resList.add(tmpInterval);
            }

        }
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
