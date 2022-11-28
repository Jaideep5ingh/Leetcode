package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class PrintSmallestNode_BST_GFG {

    public static int smallestNode(TreeNode root){
        if(root == null) return 0;
        if(root.left == null) return root.val;
        return smallestNode(root.left);
    }
    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = DsScratch.bst_insert(tree.root, 5);
        DsScratch.bst_insert(tree.root, 8);
        DsScratch.bst_insert(tree.root, 3);
        DsScratch.bst_insert(tree.root, 7);
        DsScratch.bst_insert(tree.root, 2);
        DsScratch.bst_insert(tree.root, 4);

        System.out.println(smallestNode(tree.root));
    }
}
