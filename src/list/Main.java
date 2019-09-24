package list;

/**
 * Created by zhh on 2019/9/17.
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        l1.next.next.next=null;
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        l2.next.next.next=null;
        MergeTwoSortedLists.mergeTwoLists(l1,l2);
    }
}
