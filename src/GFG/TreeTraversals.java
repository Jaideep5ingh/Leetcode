package GFG;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;


public class TreeTraversals {
    TreeNode root = new TreeNode();

    static void inOrder_recursion(TreeNode root){
        if(root == null){
            return;
        }

        inOrder_recursion(root.left);
        System.out.print(root.val + " ");
        inOrder_recursion(root.right);
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        inOrder_recursion(tree.root);
        System.out.println("");
        inOrder_Stack(tree.root);
    }
}
