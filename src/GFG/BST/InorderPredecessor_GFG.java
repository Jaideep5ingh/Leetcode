package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class InorderPredecessor_GFG {

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

    static TreeNode predecessor;
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p){
        predecessor = null;
        if(root == null) return null;

        if(p.left!=null){
            TreeNode leftmost = p.left;
            while(leftmost.left !=null) leftmost = leftmost.left;
            predecessor = leftmost;
        }else inorderPredecessor2(root, p, null);
        return predecessor;
    }

    private static void inorderPredecessor2(TreeNode root, TreeNode p, TreeNode previous) {
        if(root == null) return ;

        if(root == p && predecessor == null){
            predecessor = previous;
            return;
        }
        inorderPredecessor2(root.left, p, root);
        inorderPredecessor2(root.right, p,root);
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

        TreeNode ioPredecessor = inorderPredecessor(tree.root, searchNode);
        System.out.println(ioPredecessor.val);
    }
}
