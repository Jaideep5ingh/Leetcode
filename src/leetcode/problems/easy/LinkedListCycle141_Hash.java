package leetcode.problems.easy;

import java.util.HashMap;

public class LinkedListCycle141_Hash {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//  ListNode second = new ListNode(2);
//  ListNode third = new ListNode(3);
//  ListNode fourth = new ListNode(4);

//  head.next = second;
//  second.next = third;
//  third.next = fourth;
//  fourth.next = second;
        if (head == null || head.next==null) {
            System.out.println("No Cycle detected");
            System.exit(0);
        }

        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        int count = 1;

        ListNode current = head;
        while(current!=null){
            if (hashMap.containsKey(current)){
                break;
            }
            hashMap.put(current, count++);
            current = current.next;
        }
        System.out.println(current==null?"No Cycle":"Cycle Detected");
    }
}
