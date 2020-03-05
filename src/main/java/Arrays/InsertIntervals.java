package Arrays;

import java.util.LinkedList;

/**
 * @author Honghan Zhu
 * @leetcode 57
 * @grade hard
 */
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (newInterval[0] > curInterval[1] || newInterval[1] < curInterval[0]) {
                if (!inserted && newInterval[1] < curInterval[0]) {
                    inserted = true;
                    list.add(newInterval);
                }
                list.add(curInterval);
            } else {
                int[] insertInterval = new int[2];
                insertInterval[0] = Math.min(curInterval[0], newInterval[0]);
                insertInterval[1] = Math.max(curInterval[1], newInterval[1]);
                if (!list.isEmpty() && list.getLast()[0] == insertInterval[0])
                    list.removeLast();
                newInterval[0] = insertInterval[0];
                newInterval[1] = insertInterval[1];
                list.add(insertInterval);
                inserted = true;
            }
        }
        if (list.isEmpty() || !inserted)
            list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
}
