package Greedy;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 135
 * @grade hard
 */
public class Candy {
    public int candy(int[] ratings) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < ratings.length; i++) {
            if (!map.containsKey(ratings[i]))
                map.put(ratings[i], new ArrayList<>());
            List<Integer> l = map.get(ratings[i]);
            l.add(i);
        }
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        map.entrySet().stream().forEach(entry -> {
            List<Integer> list = entry.getValue();
            for (int i : list) {
                if (i > 0 && ratings[i] > ratings[i - 1])
                    candy[i] = Math.max(candy[i], candy[i - 1] + 1);
                if (i < ratings.length - 1 && ratings[i] > ratings[i + 1])
                    candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        });
        int res = 0;
        for (int i = 0; i < candy.length; i++)
            res += candy[i];
        return res;
    }
}
