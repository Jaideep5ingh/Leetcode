package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class InvertTree226 {

    static void inOrder_recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder_recursion(root.left);
        System.out.print(root.val + " ");
        inOrder_recursion(root.right);
    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rootLeft = invertTree(root.left);
        TreeNode rootRight = invertTree(root.right);

//        TreeNode temp = rootLeft;
        root.left = rootRight;
        root.right = rootLeft;

        return root;
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.right.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(9);
        inOrder_recursion(tree.root);
        System.out.println(" ----- Now calling Invert method");
        invertTree(tree.root);
        inOrder_recursion(tree.root);
        System.out.println("");
    }
}
