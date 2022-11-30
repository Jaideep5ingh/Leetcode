package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class InorderSuccessorInBST285 {
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
    public static TreeNode inorderSuccessor_BSTprops(TreeNode root, int key){
        TreeNode successor = null;
        while (root != null){
            if(root.val <= key) root = root.right;
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 6);
        bst_insert(tree.root, 8);
        bst_insert(tree.root, 2);
        bst_insert(tree.root, 1);
        bst_insert(tree.root, 4);
        bst_insert(tree.root, 3);

        TreeNode ioSuccessor = inorderSuccessor_BSTprops(tree.root, 2);

        System.out.println(ioSuccessor == null ? null : ioSuccessor.val);
    }

}
