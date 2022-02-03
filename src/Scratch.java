public class Scratch {
 //Definition for singly-linked list.
  public static void main(String[] args) {
   int length = 0;
   int counter= 1;
   ListNode sixth = new ListNode(1,null);
   ListNode fifth = new ListNode(1,sixth);
//   ListNode fifth = new ListNode(1,null);

   ListNode fourth = new ListNode(2,fifth);
   ListNode third = new ListNode(3,fourth);
   ListNode second = new ListNode(4,third);
   ListNode head = new ListNode(5,second);

   ListNode.display(head);
   length = length(head);
   ListNode current = head ;
   int middle_element = (length/2) +1;

   while(counter <= middle_element){
    if (counter == middle_element){
     System.out.println("Middle Element : "  + current.val);
     break;
    }
    counter++;
    current= current.next;
   }
  }

  public static int length(ListNode head){
   ListNode current = head ;
   int length = 0;
   while(current!=null){
    length++;
    current= current.next;
   }
   return length;
  }
 }
