package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class PathSum112_Recursion {

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.right.left = new TreeNode(13);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);

        int targetSum= 22;

        System.out.println(pathSum(tree.root, targetSum));

    }
    static boolean pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        targetSum -= root.val;

        if((root.right == null) && (root.left == null))
            return (targetSum==0);

        return pathSum(root.left, targetSum) || pathSum(root.right, targetSum);

    }
}
