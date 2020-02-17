package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Honghan Zhu
 * @leetcode 215
 * @grade medium
 */
public class KthLargestElementInArray {

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++)
            queue.offer(nums[i]);
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = nums[0];
            nums[0] = nums[--len];
            adjustHeap(nums, 0, len);
        }
        return res;
    }

    private void adjustHeap(int[] nums, int idx, int len) {
        while (idx < len) {
            int lchild = 2 * idx + 1;
            int rchild = lchild + 1;
            int select = lchild;
            if (lchild >= len)
                break;
            if (rchild < len) {
                select = nums[lchild] > nums[rchild] ? lchild : rchild;
            }
            if (nums[select] > nums[idx]) {
                swap(nums, idx, select);
                idx = select;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
