package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintRightViewOfBinaryTree199 {
    static List<Integer> res= new ArrayList<>();
    public static List<Integer> rightSideView(TreeNode root, int level) {
        if(level == res.size()){
            res.add(root.val);
        }
        if(root.right != null)
            rightSideView(root.right, level + 1);
        if(root.left != null)
            rightSideView(root.left, level + 1);

        return res;
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new com.company.dataStructures.implementations.TreeNode(1);
//        tree.root.right.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);

        if (tree.root == null)
            System.exit(0);
        System.out.println(rightSideView(tree.root, 0));
    }
}
