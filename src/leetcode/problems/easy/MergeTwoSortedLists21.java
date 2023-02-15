package leetcode.problems.easy;

public class MergeTwoSortedLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode fifth = new ListNode(4, null);
        ListNode fourth = new ListNode(3, fifth);
        ListNode head2 = new ListNode(1, fourth);

        ListNode third = new ListNode(4, null);
        ListNode second = new ListNode(2, third);
        ListNode head1 = new ListNode(1, second);

        ListNode mergedHead = mergeTwoLists(head1, head2);
        while (mergedHead != null) {
            System.out.print(mergedHead.val + "--->");
            mergedHead = mergedHead.next;
        }
        System.out.print("null");
//
    }
}
