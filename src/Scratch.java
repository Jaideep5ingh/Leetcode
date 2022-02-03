public class Scratch {
 //Definition for singly-linked list.
  public static void main(String[] args) {
   ListNode fifth = new ListNode(1,null);
   ListNode fourth = new ListNode(2,fifth);
   ListNode third = new ListNode(3,fourth);
   ListNode second = new ListNode(4,third);
   ListNode head = new ListNode(5,second);

   ListNode.display(head);

  }
 }
