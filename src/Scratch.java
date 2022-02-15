import javafx.util.Pair;
import java.util.*;


public class Scratch {
 public static void main(String[] args) {
  ListNode head1 = new ListNode(4);
  ListNode l1first = new ListNode(1);
  ListNode l1second = new ListNode(8);
  ListNode l1third = new ListNode(4);

  head1.next = l1first;
  l1first.next = l1second;
  l1second.next = l1third;

  ListNode slow = new ListNode();
  ListNode fast = new ListNode();


  int n=3;

  for (int i = 1; i <= n; i++) {
   fast = fast.next;
  }

  while(fast!=null){
   fast = fast.next;
   slow= slow.next;
  }
  slow.next = slow.next.next;
 }
 }


