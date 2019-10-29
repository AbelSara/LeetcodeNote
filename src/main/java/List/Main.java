package List;

/**
 * Author:Honghan Zhu
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        l1.next=new ListNode(1);
        l1.next.next=new ListNode(8);
        l1.next.next.next=new ListNode(4);
        l1.next.next.next.next=new ListNode(5);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(0);
        l2.next.next=new ListNode(1);
        l2.next.next.next=new ListNode(8);
        l2.next.next.next.next=new ListNode(4);
        l2.next.next.next.next.next=new ListNode(5);
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(l1,l2));
    }
}
