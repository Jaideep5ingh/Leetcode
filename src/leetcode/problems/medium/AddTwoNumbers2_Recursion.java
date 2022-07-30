package leetcode.problems.medium;

import leetcode.problems.easy.ListNode;

public class AddTwoNumbers2_Recursion {
    static leetcode.problems.easy.ListNode resList = new leetcode.problems.easy.ListNode();
    static leetcode.problems.easy.ListNode head = resList;
    static int carry =0;

    public static void main(String[] args) {
        leetcode.problems.easy.ListNode five = new leetcode.problems.easy.ListNode(9, null);
        leetcode.problems.easy.ListNode four = new leetcode.problems.easy.ListNode(9, five);
        leetcode.problems.easy.ListNode two = new leetcode.problems.easy.ListNode(9, four);
        leetcode.problems.easy.ListNode head1 = new leetcode.problems.easy.ListNode(9, two);

//        ListNode six = new ListNode(6, null);
//        ListNode five = new ListNode(5, six);
//        ListNode four2 = new ListNode(3, null);
        leetcode.problems.easy.ListNode three = new leetcode.problems.easy.ListNode(9, null);
        leetcode.problems.easy.ListNode head2 = new leetcode.problems.easy.ListNode(9, three);

        leetcode.problems.easy.ListNode current = addTwoLists(head1, head2);

//        current = current.next;
        while (current!=null){
            System.out.println(current.val);
            current= current.next;
        }
    }

    public static leetcode.problems.easy.ListNode addTwoLists(leetcode.problems.easy.ListNode head1, leetcode.problems.easy.ListNode head2) {
        int sum = head1.val + head2.val + carry;
        carry  = sum / 10;
        resList.next = new leetcode.problems.easy.ListNode(sum % 10);
        resList = resList.next;

        if(head1.next != null && head2.next != null)
            addTwoLists(head1.next, head2.next);
        else if (head1.next != null)
            addTwoLists(head1.next, new leetcode.problems.easy.ListNode(0));
        else if (head2.next != null)
            addTwoLists(new leetcode.problems.easy.ListNode(0), head2.next);
        else if (carry > 0)
        {
            resList.next = new ListNode(1);
            resList = resList.next;
        }

        return head.next;
    }
}
