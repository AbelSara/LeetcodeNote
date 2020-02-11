package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author Honghan Zhu
 * @leetcode 621
 * @grade medium
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        int[] array = new int[26];
        for (char c : tasks)
            array[c - 'A'] += 1;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i : array)
            if (i != 0) queue.offer(i);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int i = 0;
            while (i <= n && !queue.isEmpty()) {
                int val = queue.poll();
                if (val > 1) {
                    list.add(val - 1);
                }
                res += 1;
                i += 1;
            }
            if (i <= n && !list.isEmpty())
                res += n - i + 1;
            queue.addAll(list);
        }
        return res;
    }
}
