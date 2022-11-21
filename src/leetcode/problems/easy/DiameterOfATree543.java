package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class DiameterOfATree543 {
    static int diameter;
    static int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftPath = diameter(root.left);
        int rightPath = diameter(root.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
//        tree.root.right.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(5);
//        tree.root.right.right = new TreeNode(9);
        System.out.println(diameter(tree.root));
    }
}
