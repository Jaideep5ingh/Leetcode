import javafx.util.Pair;
import java.util.*;


public class Scratch {
 public static void main(String[] args) {
  ListNode head1 = new ListNode(4);
  ListNode l1first = new ListNode(1);
  ListNode l1second = new ListNode(8);
  ListNode l1thrid = new ListNode(4);
  ListNode head2 = new ListNode(5);
  ListNode l2second = new ListNode(1);
  ListNode l2thrid = new ListNode(8);
  ListNode l2fourth = new ListNode(4);

  head1.next = l1first;
  l1first.next = l1second;
  l1second.next = l1thrid;

  head2.next = l2second;
  l2second.next = l2thrid;
  l2thrid.next = l2fourth;


 }
 }


