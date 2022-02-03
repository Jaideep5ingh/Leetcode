import com.company.dataStructures.implementations.SinglyLinkedList;

public class ListNode {
    int val;
    ListNode next;


    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " ---->");
            current = current.next;
        }

        System.out.println("null");
    }
}
