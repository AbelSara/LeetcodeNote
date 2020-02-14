package Hash;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 347
 * @grade medium
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int times = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], times);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());
        List<Integer> resList = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            resList.add(queue.poll().getKey());
        }
        return resList;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int times = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], times);
        }
        List<Integer>[] bucket = new LinkedList[nums.length + 1];
        map.entrySet().stream().forEach(entry -> {
            int key = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null)
                bucket[val] = new LinkedList<>();
            bucket[val].add(key);
        });
        List<Integer> resList = new LinkedList<>();
        for (int i = bucket.length - 1; i >= 0 && resList.size() < k; i--)
            if (bucket[i] != null)
                resList.addAll(bucket[i]);
        return resList;
    }
}
