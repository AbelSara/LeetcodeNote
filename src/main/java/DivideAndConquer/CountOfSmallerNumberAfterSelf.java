package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 315
 * @grade hard
 */
public class CountOfSmallerNumberAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int[] count = new int[nums.length];
        int[] idx = new int[nums.length];
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            idx[i] = i;
        mergeSort(nums, idx, count, tmp, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++)
            res.add(count[i]);
        return res;
    }

    private void mergeSort(int[] nums, int[] idx, int[] count, int[] tmp, int left, int right) {
        if (left == right)
            return;
        int mid = (left + right) >> 1;
        mergeSort(nums, idx, count, tmp, left, mid);
        mergeSort(nums, idx, count, tmp, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        int numOfCastleWall = 0;
        while (i <= mid && j <= right) {
            int leftIdx = idx[i];
            int rightIdx = idx[j];
            if (nums[leftIdx] <= nums[rightIdx]) {
                tmp[k++] = leftIdx;
                count[leftIdx] += numOfCastleWall;
                i += 1;
            } else {
                tmp[k++] = rightIdx;
                numOfCastleWall = j - mid;
                j += 1;
            }
        }
        while (i <= mid) {
            count[idx[i]] += numOfCastleWall;
            tmp[k++] = idx[i++];
        }
        while (j <= right) {
            tmp[k++] = idx[j++];
        }
        while (left <= right)
            idx[left] = tmp[left++];
    }
}
