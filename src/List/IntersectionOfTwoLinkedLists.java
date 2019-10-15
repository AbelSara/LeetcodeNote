package List;

/**
 * @author: Honghan Zhu
 * @leetcode: 160
 * @grade: easy
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        int sumA = 0, sumB = 0;
        for (ListNode p = headA; null != p.next; p = p.next, sumA++) ;
        for (ListNode p = headB; null != p.next; p = p.next, sumB++) ;
        ListNode p = headA, q = headB;
        while (sumA > sumB) {
            p = p.next;
            sumA -= 1;
        }
        while (sumB > sumA) {
            q = q.next;
            sumB -= 1;
        }
        while (p != null && q != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
