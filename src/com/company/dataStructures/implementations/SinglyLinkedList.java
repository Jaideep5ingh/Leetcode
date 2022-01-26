package com.company.dataStructures.implementations;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + " ---->");
            current = current.next;
        }

        System.out.println("null");
    }

    int length(){
        ListNode current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode firstNode = new ListNode(value);
        firstNode.next = head;
        head = firstNode;
    }

    public void insertlast(int value){
        ListNode newNode = new ListNode(value);
        ListNode current = head;

        if(head == null){
            head = newNode;
            return;
        }
        
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void insertAtPosition(int position,  int value){
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        int counter = 0;

        if(position == 1){
            newNode.next  = head;
            head = newNode;
        }else{
            ListNode prevNode = head;
            while(prevNode != null && counter < position - 2){
                prevNode = prevNode.next;
                counter++;
            }if (prevNode == null){
                System.out.println("Cannot insert at position : " + position);
                return;
            }else{
                current = prevNode.next;
                prevNode.next = newNode;
                newNode.next = current;
            }
        }
    }

    public void deleteFirst(){
        if (head==null){
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        ListNode current = head;
        int counter=0;

        if (head==null ){
            return;
        }
        while (current.next!=null && counter<length()-2){
            current = current.next;
            counter++;
        }
        current.next = null;
    }


    public void deleteAtPosition(int position){
        ListNode current = head;
        ListNode previous = null;
        ListNode temp = null;
        int counter=0;

        if (position==1){
            head = head.next;
            return;
        }
        while (current.next!=null && counter<position-1){
            current = current.next;
            counter++;
        }

        previous = current;
        previous.next = current.next;
    }

    public boolean find(int key){
        ListNode current = head;
        while (current != null ){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void removeDupes(){
        ListNode current = head;
        if (head == null || head.next == null){
              return;
        }

        while (current!=null && current.next!=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else
                current = current.next;
        }
    }

    public void reverse(){
        ListNode current   = head;
        ListNode previous = null;
        ListNode next = null;

        if (head == null || head.next == null){
            return;
        }
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public static void main(String[] args) {
	// write your code here
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        singlyLinkedList.head = new ListNode(10);
//
//        SinglyLinkedList.ListNode second = new SinglyLinkedList.ListNode(50);
//        ListNode third = new ListNode(60);
//        ListNode fourth = new ListNode(80);
//
//        singlyLinkedList.head.next = second;
//        second.next = third;
//        third.next = fourth;
//
//        singlyLinkedList.insertFirst(50);
//        singlyLinkedList.insertlast(30);
//
//        singlyLinkedList.display();
//
//        System.out.println(singlyLinkedList.head.data);

        singlyLinkedList.insertAtPosition(1,10);
        singlyLinkedList.insertAtPosition(2,5);
        singlyLinkedList.insertAtPosition(3,84);
        singlyLinkedList.insertAtPosition(4,44);

        singlyLinkedList.display();

        singlyLinkedList.deleteAtPosition(2);

        ListNode current = singlyLinkedList.head;
        for (int i = 0; current!= null; i++) {
            System.out.println("Node at " + i + "th position is : " + current.data);
            current = current.next;
        }
        System.out.println("null");

        System.out.println("Was the key found? " + singlyLinkedList.find(10) );

        System.out.println("The reversed list is : " );

        singlyLinkedList.reverse();

        singlyLinkedList.display();
    }

}
