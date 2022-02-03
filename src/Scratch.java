public class Scratch {
 //Definition for singly-linked list.
  public static void main(String[] args) {
   int length = 0;
   int counter = 1;

   ListNode sixth = new ListNode(1, null);
   ListNode fifth = new ListNode(1, sixth);
   ListNode fourth = new ListNode(2, fifth);
   ListNode third = new ListNode(3, fourth);
   ListNode second = new ListNode(4, third);
   ListNode head = new ListNode(5, second);

   ListNode fast = head;
   ListNode slow = head;

   while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
   }
   System.out.println(slow.val);
  }
 }
