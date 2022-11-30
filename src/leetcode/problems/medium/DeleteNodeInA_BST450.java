package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class DeleteNodeInA_BST450 {
    static TreeNode searchNode;
    public static TreeNode bst_insert(TreeNode root, int key){
        if(root == null){
            searchNode =  new TreeNode(key);
            return searchNode;
        }
        if(root.val > key){
            root.left = bst_insert(root.left, key);
        }
        else if(root.val < key){
            root.right = bst_insert(root.right, key);
        }
        return root;
    }

    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val <= key) root.right = deleteNode(root.right, key);
        else{
            if(root.left == null && root.right == null) root = null;
            else if(root.right !=null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 6);
        bst_insert(tree.root, 2);
        bst_insert(tree.root, 4);
        bst_insert(tree.root, 1);
        bst_insert(tree.root, 8);
//        bst_insert2(tree.root, 5);

        DsScratch.inOrder_Stack(tree.root);
        System.out.println(" ");
        deleteNode(tree.root, 2);
        DsScratch.inOrder_Stack(tree.root);
        System.out.println(" ");
    }
}
