package Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Honghan Zhu
 * @leetcode 349
 * @grade easy
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;

            }
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}
