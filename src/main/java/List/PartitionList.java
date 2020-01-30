package List;

import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 86
 * @grade medium
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (null == head) return null;
        ListNode resList = new ListNode(Integer.MAX_VALUE);
        ListNode firstPart = resList, secondPart = resList;
        while (head != null) {
            ListNode tmpNode = head.next;
            if (head.val < x) {
                head.next = firstPart.next;
                ListNode preNode = firstPart;
                firstPart.next = head;
                firstPart = firstPart.next;
                if (secondPart == preNode)
                    secondPart = firstPart;
            } else {
                head.next = secondPart.next;
                secondPart.next = head;
                secondPart = secondPart.next;
            }
            head = tmpNode;
        }
        return resList.next;
    }
}
