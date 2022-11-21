package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class BalancedBinaryTree110 {
    static boolean isBalanced(TreeNode root) {
        if(root == null ) return true;
        int left = subTreeHeight(root.left) + 1;
        int right = subTreeHeight(root.right) + 1;
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int subTreeHeight(TreeNode root){
        if(root == null ) return 0;

        int leftHeight = subTreeHeight(root.left);
        int rightHeight = subTreeHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
//        DsScratch tree = new DsScratch();
//        tree.root = new TreeNode(1);
//        tree.root.left = new TreeNode(2);
//        tree.root.right = new TreeNode(2);
//        tree.root.left.left = new TreeNode(3);
//        tree.root.left.right = new TreeNode(3);
//        tree.root.left.left.right = new TreeNode(4);
//        tree.root.left.left.right = new TreeNode(4);
//        System.out.println(isBalanced(tree.root));


        DsScratch tree2 = new DsScratch();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(2);
        tree2.root.left.left = new TreeNode(3);
//        tree2.root.right.left = new TreeNode(5);
        tree2.root.left.right = new TreeNode(4);
//        tree2.root.right.right = new TreeNode(3);
        System.out.println(isBalanced(tree2.root));
    }
}
