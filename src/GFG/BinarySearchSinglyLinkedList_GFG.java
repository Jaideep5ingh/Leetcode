package GFG;

import leetcode.problems.easy.ListNode;

public class BinarySearchSinglyLinkedList_GFG {
    public static boolean binarySearchLinkedList(ListNode head, int target) {
        ListNode left = head;
        ListNode right = null;

        do{
            ListNode mid = findCenterNode(left, right);
            if(mid == null) return false;
            if(mid.val == target) return true;
            else if(mid.val < target)  left = mid.next;
            else right = mid;
        }while(right == null || left!=right);
        return false;
    }

    public static ListNode findCenterNode(ListNode left, ListNode right){
        if (left == null)
            return null;

        ListNode fast = left.next;
        ListNode slow = left;
        while(fast != right){
            fast = fast.next;
            if(fast!=right){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(4, null);
        ListNode four = new ListNode(3, five);
        ListNode two = new ListNode(2, four);
        ListNode head1 = new ListNode(1, two);

        System.out.println(binarySearchLinkedList(head1, 5));

    }
}
