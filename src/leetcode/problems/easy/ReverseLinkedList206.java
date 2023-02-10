package leetcode.problems.easy;

import Revision.DataStructures.ListNode;
import Revision.DataStructures.SinglyLinkedList;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(3, 4);
        myLinkedList.addAtIndex(4, 5);
        myLinkedList.display();

        //handle for a single node.
        if (myLinkedList.head == null || myLinkedList.head.next==null){
            myLinkedList.display();
            System.exit(0);
        }

        Revision.DataStructures.ListNode current = myLinkedList.head.next;
        Revision.DataStructures.ListNode orgHead = myLinkedList.head;
        while(current!=null){
            ListNode next = current.next;
            current.next = myLinkedList.head;
            myLinkedList.head = current;
            orgHead.next = next;
            current = next;
        }

        myLinkedList.display();
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
