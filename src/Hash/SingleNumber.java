package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:Honghan Zhu
 * leetcode:136
 * Grade:easy
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (1 == (int) entry.getValue()) {
                return (int) entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumPlus(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }
}
