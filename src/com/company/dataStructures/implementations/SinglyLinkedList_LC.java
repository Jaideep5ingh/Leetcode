package com.company.dataStructures.implementations;

public class SinglyLinkedList_LC {

    private ListNode head;

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
            this.val = 0;
            this.next = null;
        }
    }

    public SinglyLinkedList_LC() {
        this.head = new ListNode();
    }

    public int get(int index) {
        ListNode current = head;
        int length = length();
        int counter = 0;

        while (current!= null && counter<length - 1){
            current = current.next;
            counter++;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        head.val = val;
    }
//
    public void addAtTail(int val) {
        ListNode current = head;
        ListNode newNode = new ListNode();
        newNode.val = val;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode current = head;
        ListNode previous = null;
        ListNode newNode = new ListNode();
        newNode.val = val;

        if(index == 0 ){
            newNode.next  = head;
            head = newNode;
            return;
        }

        int counter = 0;

        while (current!= null && counter<index){
            previous = current;
            current = current.next;
            counter++;
        }
        newNode.next = current;
        previous.next = newNode;

    }

    public void deleteAtIndex(int index) {
        ListNode current = head;
        ListNode previous = current;
        int counter = 0;

        if(index == 0 ){
            head = head.next;
            return;
        }

        while (current!= null && counter<index){
            previous = current;
            current = current.next;
            counter++;
        }

        previous.next = current.next;

    }

    public int length(){
        ListNode current = head;
        int counter = 0;

        while(current!=null){
            current = current.next;
            counter++;
        }
        return counter;
    }

    void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " ---->");
            current = current.next;
        }

        System.out.println("null");
    }


    public static void main(String[] args){
        SinglyLinkedList_LC obj = new SinglyLinkedList_LC();
        int param_1 = obj.get(0);

        System.out.println(param_1);

        ListNode test = new ListNode();

        obj.addAtHead(384);
        obj.addAtTail(235);
        obj.addAtIndex(1,463);
        obj.addAtIndex(4,44353);

        obj.display();

        obj.deleteAtIndex(1);

        obj.display();
    }

}

/**
 * Your SinglyLinkedList_LC object will be instantiated and called as such:
 * SinglyLinkedList_LC obj = new SinglyLinkedList_LC();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
