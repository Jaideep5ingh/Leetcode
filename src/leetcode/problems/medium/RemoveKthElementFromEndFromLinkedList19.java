package leetcode.problems.medium;

import leetcode.problems.easy.ListNode;

public class RemoveKthElementFromEndFromLinkedList19 {
    public static void main(String[] args) {
        int length = 0;
        int counter= 1;
        int n=2;

//   ListNode sixth = new ListNode(1,null);
//   ListNode fifth = new ListNode(1,sixth);
        ListNode fourth = new ListNode(4,null);
        ListNode third = new ListNode(3,fourth);
        ListNode second = new ListNode(2,third);
        ListNode head = new  ListNode(1,second);

        System.out.println(" Original Linked List =  ");
        leetcode.problems.easy.ListNode.display(head);

        length = length(head);
        int find = length - n;
        leetcode.problems.easy.ListNode current = head;


        while(counter<=find){
            counter++;
            current= current.next;
        }

        current.next = current.next.next;

        System.out.println("Linked List after removal = ");
        leetcode.problems.easy.ListNode.display(head);

    }
    public static int length(ListNode head){
        ListNode current = head;
        int length = 0;
        while(current!=null){
            length++;
            current= current.next;
        }
        return length;
    }
}
