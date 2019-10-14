package List;

/**
 * Author:Honghan Zhu
 * leetcode:83
 * Grade:easy
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode p = result;
        while (null != head) {
            if (p.val != head.val) {
                p.next = head;
                head = head.next;
                p = p.next;
                p.next = null;
            } else if (p.val == head.val) {
                head = head.next;
            }
        }
        return result.next;
    }
}



