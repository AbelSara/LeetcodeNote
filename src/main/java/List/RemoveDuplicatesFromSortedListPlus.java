package List;

/**
 * @Author Honghan Zhu
 * @leetcode 82
 * @grade medium
 */
public class RemoveDuplicatesFromSortedListPlus {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resList = new ListNode(-1);
        ListNode tmpList = resList;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int tmp = head.val;
                while (head != null && head.val == tmp)
                    head = head.next;
            } else {
                ListNode nextNode = head.next;
                tmpList.next = head;
                head.next = null;
                head = nextNode;
                tmpList = tmpList.next;
            }
        }
        return resList.next;
    }
}
