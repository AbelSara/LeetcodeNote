package Design;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 146
 * @grade medium
 */
public class LRUCache {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        map.remove(key);
        if (map.size() == this.capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}
