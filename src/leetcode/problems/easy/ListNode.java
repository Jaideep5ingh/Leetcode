package leetcode.problems.easy;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + " ---->");
            current = current.next;
        }

        System.out.println("null");
    }
}
