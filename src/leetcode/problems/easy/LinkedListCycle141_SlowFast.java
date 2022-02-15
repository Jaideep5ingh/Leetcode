package leetcode.problems.easy;

import java.util.List;

public class LinkedListCycle141_SlowFast {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode fourth = new ListNode(4);

        head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = second;
        if (head == null || head.next==null) {
            System.out.println("No Cycle detected");
            System.exit(0);
    }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                System.out.println("Cycle detected");
                System.exit(0);
            }
        }

    }
}
