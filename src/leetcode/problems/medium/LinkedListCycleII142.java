package leetcode.problems.medium;

public class LinkedListCycleII142 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode l1first = new ListNode(1);
        ListNode l1second = new ListNode(8);
        ListNode l1third = new ListNode(4);

        head1.next = l1first;
        l1first.next = l1second;
        l1second.next = l1third;
        l1third.next = l1first;

        if (head1 == null || head1.next==null) {
            System.out.println("No Cycle detected");
            System.exit(0);
        }

        ListNode slow = head1;
        ListNode fast = head1;

        while (fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                break;
            }
        }
        slow = head1;

        while(fast!=slow){
            fast = fast.next;
            slow= slow.next;
        }

        System.out.println(slow.val);
    }
}
