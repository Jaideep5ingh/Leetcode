package leetcode.problems.medium;

import leetcode.problems.easy.ListNode;

public class SwapNodesInPairs24_Recursion {

    public static void main(String[] args) {
        leetcode.problems.easy.ListNode five = new leetcode.problems.easy.ListNode(4, null);
        leetcode.problems.easy.ListNode four = new leetcode.problems.easy.ListNode(3, five);
        leetcode.problems.easy.ListNode two = new leetcode.problems.easy.ListNode(2, four);
        leetcode.problems.easy.ListNode head1 = new leetcode.problems.easy.ListNode(1, two);

        leetcode.problems.easy.ListNode current = swapInPair(head1);
        while (current!=null){
            System.out.println(current.val);
            current= current.next;
        }
    }

    public static leetcode.problems.easy.ListNode swapInPair(leetcode.problems.easy.ListNode head){
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        leetcode.problems.easy.ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapInPair(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
