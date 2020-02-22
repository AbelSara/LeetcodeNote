package Heap;

import List.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Honghan Zhu
 * @leetcode 23
 * @grade hard
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null)
                heap.offer(list);
        }
        if (heap.isEmpty())
            return null;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (!heap.isEmpty()) {
            ListNode curNode = heap.poll();
            ListNode tmpNode = curNode.next;
            curNode.next = null;
            p.next = curNode;
            p = p.next;
            if (tmpNode != null)
                heap.offer(tmpNode);
        }
        return res.next;
    }
}
