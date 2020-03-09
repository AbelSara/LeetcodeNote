package Hash;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 219
 * @grade easy
 */
public class ContainsDuplicatePlus {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i]))
                return true;
            window.add(nums[i]);
            if (window.size() > k)
                window.remove(nums[i - k]);
        }
        return false;
    }
}
