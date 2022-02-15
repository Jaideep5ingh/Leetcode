package Revision;

public class SinglyLinkedList {
    ListNode head;

    public SinglyLinkedList() {
        this.head = new ListNode();
    }

    public SinglyLinkedList(ListNode head) {
        this.head = head;
    }

    private void addAtHead(int i) {
        
    }

    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.addAtHead(1);
    }


}

class ListNode{
    int val;
    ListNode next;

    ListNode(){
    }

    ListNode(int val){
        this.val = val;
    }
}