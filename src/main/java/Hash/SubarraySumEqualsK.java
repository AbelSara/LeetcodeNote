package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Honghan Zhu
 * @leetcode 560
 * @grade medium
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
