package leetcode.problems.medium;


import com.company.dataStructures.implementations.TreeNode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList426_Recursion {

    static TreeNode first = null;
    static TreeNode last = null;

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);

        TreeNode first = convert(root);

        TreeNode current = first;

        do{
            System.out.print(current.val);
            System.out.print("-->");
            current = current.right;
        }while(current.val != 5);

        System.out.print("-->");
        System.out.print(current.val);

    }
    public static TreeNode convert(TreeNode root){

        if(root == null) {
            return null;
        }

        helper(root);

        first.left = last;
        last.right = first;

        return first;
    }

    public static void helper(TreeNode node){
        if (node!= null){
            helper(node.left);

            if(last != null){
                last.right = node;
                node.left = last;
            }else{
                first = node;
            }
            last = node;

            helper(node.right);
        }
    }
}
