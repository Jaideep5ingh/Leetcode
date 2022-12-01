package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST130 {
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

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while(true){
            while(root!= null){
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
    public static void main(String[] args) {
//        <=============BST Trees===============>
        int k = 2;
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 3);
        bst_insert(tree.root, 4);
        bst_insert(tree.root, 1);
        bst_insert(tree.root, 2);
//        bst_insert(tree.root, 8);
//        bst_insert(tree.root, 7);
//        bst_insert(tree.root, 9);
        kthSmallest(tree.root, k);
    }
}
