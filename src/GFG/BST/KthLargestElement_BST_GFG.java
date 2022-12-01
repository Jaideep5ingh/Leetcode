package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.ArrayList;

public class KthLargestElement_BST_GFG {

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
    static ArrayList<Integer> list = new ArrayList<>();
    public static void kthLargestElement(TreeNode root){
       if(root == null) return;
       kthLargestElement(root.right);
       list.add(root.val);
       kthLargestElement(root.left);
    }

    public static class count {
        int c = 0;
    }

    public static void kthLargestElement_const_space(TreeNode root, int k, count count){
        if(root == null || count.c >= k) return;

        kthLargestElement_const_space(root.right, k, count);
        count.c++;
        if(count.c == k){
            System.out.println(root.val);
            return;
        }
        kthLargestElement_const_space(root.left, k, count);
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
        kthLargestElement_const_space(tree.root, k, new count());
    }
}
