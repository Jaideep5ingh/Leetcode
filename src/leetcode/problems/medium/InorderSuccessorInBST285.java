package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class InorderSuccessorInBST285 {
    static TreeNode searchNode;
    static TreeNode previous;
    static TreeNode successor;

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

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(p.right!=null){
            TreeNode leftmost = p.right;
            while(leftmost.left != null) leftmost = leftmost.left;
            successor = leftmost;
        }else inorderSuccessor2(root, p);

        return successor;
    }

    public static void inorderSuccessor2(TreeNode root, TreeNode p){
        if(root == null) return;
        inorderSuccessor(root.left, p);

        if(previous == p && successor == null){
            successor = root;
            return;
        }

        previous = root;

        inorderSuccessor2(root.right, p);
    }

    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 6);
        bst_insert(tree.root, 8);
        bst_insert(tree.root, 2);
        bst_insert(tree.root, 4);

        TreeNode ioSuccessor = inorderSuccessor_BSTprops(tree.root, 2);
        TreeNode ioSuccessor2 = inorderSuccessor(tree.root, searchNode);

//        System.out.println(ioSuccessor == null ? null : ioSuccessor.val);
        System.out.println(ioSuccessor2.val);
    }

}
