package leetcode.problems;

import leetcode.problems.easy.ListNode;

import java.util.HashMap;
import java.util.List;



public class LinkedListScratch {
//    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static ListNode resList = new ListNode();
    static ListNode head = resList;
    static int carry =0;

    public static void main(String[] args) {
        ListNode five = new ListNode(4, null);
        ListNode four = new ListNode(3, five);
        ListNode two = new ListNode(2, four);
        ListNode head1 = new ListNode(1, two);

//        ListNode six = new ListNode(6, null);
//        ListNode five = new ListNode(5, six);
//        ListNode four2 = new ListNode(3, null);
//        ListNode three = new ListNode(9, null);
//        ListNode head2 = new ListNode(9, three);
//
        ListNode current = swapInPair(head1);
//        current = current.next;
        while (current!=null){
            System.out.println(current.val);
            current= current.next;
        }
    }

    public static ListNode swapInPair(ListNode head){
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapInPair(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
