package leetcode.problems.easy;

import Revision.DataStructures.ListNode;
import Revision.DataStructures.SinglyLinkedList;

public class OddEvenLinkedList328 {
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

        ListNode current = myLinkedList.head, firstEven = myLinkedList.head.next, even = firstEven;

        while(even!=null && even.next!=null){
            current.next = even.next;
            current = current.next;
            even.next = current.next;
            even = even.next;
        }
        current.next = firstEven;
        myLinkedList.display();
    }
}
