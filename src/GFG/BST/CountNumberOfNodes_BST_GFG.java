package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class CountNumberOfNodes_BST_GFG {

    public static TreeNode bst_insert(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }
        if(root.val > key){
            root.left = bst_insert(root.left, key);
        }
        else if(root.val < key){
            root.right = bst_insert(root.right, key);
        }
        return root;
    }

    public static int totalNodesBST(TreeNode root){
        if(root == null) return 0;
        return totalNodesBST(root.left) + totalNodesBST(root.right) + 1;
    }

    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 5);
        bst_insert(tree.root, 8);
        bst_insert(tree.root, 3);
        bst_insert(tree.root, 7);
        bst_insert(tree.root, 2);
        bst_insert(tree.root, 4);
    }
}
