package leetcode.problems.easy;

public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode l1first = new ListNode(1);
        ListNode l1second = new ListNode(8);
        ListNode l1third = new ListNode(4);

        head1.next = l1first;
        l1first.next = l1second;
        l1second.next = l1third;


        ListNode head2 = new ListNode(5);
        ListNode l2second = new ListNode(1);
        ListNode l2thrid = new ListNode(8);
        ListNode l2fourth = new ListNode(4);

        head2.next = l2second;
        l2second.next = l2thrid;
        l2thrid.next = l2fourth;

        if (head1 == null || head1.next==null) {
            System.out.println("No Cycle detected");
            System.exit(0);
        }

        ListNode pointer1 = head1;
        ListNode pointer2 = head2;

        while(pointer1!=pointer2){
            pointer1 = pointer1==null? head2:pointer1.next;
            pointer2 = pointer2==null? head1:pointer2.next;
        }
        System.out.println(pointer1);
    }
}
