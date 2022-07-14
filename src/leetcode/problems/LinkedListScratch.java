package leetcode.problems;

import leetcode.problems.easy.ListNode;

import java.util.HashMap;
import java.util.List;



public class LinkedListScratch {
//    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        ListNode four = new ListNode(4, null);
        ListNode two = new ListNode(2, four);
        ListNode head1 = new ListNode(1, two);

        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(5, six);
        ListNode four2 = new ListNode(4, five);
        ListNode three = new ListNode(3, four2);
        ListNode head2 = new ListNode(2, three);

        ListNode current = mergeTwoLists(head1, head2);
//        current = current.next;
        while (current!=null){
            System.out.println(current.val);
            current= current.next;
        }
    }

    public static ListNode mergeTwoListsJai(ListNode head1, ListNode head2) {
        //check for one of both null;
        if ((head1 == null && head2 == null)
//                || (head1.next == null && head2.next == null)
        ) {
            return null;
        }
        if ((head1 != null && head2 == null)) {
            return head1;
        }
        if ((head1 == null && head2 != null)) {
            return head2;
        }
        if (head1.val < head2.val) {
            ListNode resultHead = new ListNode();
            resultHead.next = mergeTwoListsJai(head1, head2.next);
            return resultHead;
        }
        if (head1.val > head2.val) {
            ListNode resultHead = new ListNode();
            resultHead.next = mergeTwoListsJai(head1.next, head2);
            return resultHead;
        }
        return null;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
