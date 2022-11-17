package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class SameTree100 {
    static boolean sameTree(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return (node1.val == node2.val) && sameTree(node1.left, node2.left)
                && sameTree(node1.right, node2.right);
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        DsScratch tree2 = new DsScratch();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(2);
        tree2.root.left.left = new TreeNode(3);
        tree2.root.right.left = new TreeNode(5); //replace with 4 for true
        tree2.root.left.right = new TreeNode(4);
        tree2.root.right.right = new TreeNode(3);

        System.out.println(sameTree(tree.root, tree2.root));

    }
}
