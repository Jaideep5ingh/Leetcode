package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class SubTreeOfAnotherTree {
    private static boolean subTree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isIdentical(root, subRoot)){
            return true;
        }
        return subTree(root.left, subRoot) || subTree(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }

        return isIdentical(root.left, subRoot.left) || isIdentical(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.right.left.left = new TreeNode(7);

        DsScratch tree2 = new DsScratch();
        tree2.root = new TreeNode(3);
        tree2.root.left = new TreeNode(3);
        tree2.root.right = new TreeNode(5);
        tree2.root.left.left = new TreeNode(4);
        tree2.root.right.left = new TreeNode(1);
        tree2.root.left.right = new TreeNode(2);
        tree2.root.right.right = new TreeNode(2);

        subTree(tree.root, tree2.root);
    }

}
