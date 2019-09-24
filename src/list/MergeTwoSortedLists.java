package list;

/**
 * Author:Honghan Zhu
 * leetcode:21
 * Grade:easy
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null != l2) return l2;
        else if (null != l1 && null == l2) return l1;
        else if (null == l1 && null == l2) return l1;
        ListNode result = new ListNode(0);
        result.next = null;
        ListNode p = result;
        while (l1 != null && l2 != null) {
            int tempVal;
            if (l1.val <= l2.val) {
                tempVal = l1.val;
                l1 = l1.next;
            } else {
                tempVal = l2.val;
                l2 = l2.next;
            }
            ListNode tempNode = new ListNode(tempVal);
            tempNode.next = null;
            p.next = tempNode;
            p = p.next;
        }
        if (l1 != null && l2 == null) p.next = l1;
        if (l2 != null && l1 == null) p.next = l2;
        return result.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
