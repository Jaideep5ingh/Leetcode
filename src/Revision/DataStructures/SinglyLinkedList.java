package Revision.DataStructures;

//Notes :
//        1.The leetcode implementation maintains a size variable along with a head variable
//        2. Also for addAtHead, it calls addAtIndex(0, val).
//        3. Also for addAtTail, it calls addAtIndex(size, val).
//        4. for deleteAtIndex,addAtHead,addAtTail  size variable is used instead of a counter.

public class SinglyLinkedList {
    ListNode head;

    public SinglyLinkedList() {
        this.head = new ListNode();
    }

    public SinglyLinkedList(ListNode head) {
        this.head = head;
    }

    private void addAtHead(int i) {
        this.head.val = 1;

    }

    private void addAtTail(int i) {
        ListNode current = this.head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new ListNode(i);
    }

    private void addAtIndex(int index, int val) {
        if(index==0){

        }
        int count = 1;
        ListNode current = this.head;
        while(current.next!=null && count <index){
            current = current.next;
            count++;
        }
        ListNode newNode = new ListNode(val);
        newNode.next= current.next;
        current.next= newNode;
    }

    private void deleteAtIndex(int index) {
        int count = 1;
        ListNode current = this.head;
        while(current.next!=null && count <index){
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    private int get(int index) {
        int count = 1;
        ListNode current = this.head;
        while(current.next!=null && count <index){
            current = current.next;
            count++;
        }
        return current.next==null?-1:current.next.val;
    }

    public void display(){
        ListNode current = this.head;
        while(current!=null){
            System.out.print(current.val);
            System.out.print("--->");

            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.display();
        myLinkedList.deleteAtIndex(1);
        myLinkedList.display();
        System.out.println(myLinkedList.get(1));
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