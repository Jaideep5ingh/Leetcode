package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class PrintAllNonLeafNodes_BST_GFG {

    static void printNonLeafNodes(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.left !=null || root.right !=null) System.out.println(root.val + " ");

        printNonLeafNodes(root.left);
        printNonLeafNodes(root.right);
    }
    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = DsScratch.bst_insert(tree.root, 5);
        DsScratch.bst_insert(tree.root, 8);
        DsScratch.bst_insert(tree.root, 3);
        DsScratch.bst_insert(tree.root, 7);
        DsScratch.bst_insert(tree.root, 1);
        DsScratch.bst_insert(tree.root, 4);

        printNonLeafNodes(tree.root);
    }
}
