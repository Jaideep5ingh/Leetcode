package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class FlipEquivalentBinaryTrees951 {
    public static boolean flipEquiv(com.company.dataStructures.implementations.TreeNode root1, com.company.dataStructures.implementations.TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
            return true;
        }

        else if (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) {
            return true;
        }

        else {
            return false;
        }

    }


    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new com.company.dataStructures.implementations.TreeNode(1);
        tree.root.left = new com.company.dataStructures.implementations.TreeNode(3);
        tree.root.right = new com.company.dataStructures.implementations.TreeNode(2);
        tree.root.right.left = new com.company.dataStructures.implementations.TreeNode(5);

        DsScratch tree2 = new DsScratch();
        tree2.root = new com.company.dataStructures.implementations.TreeNode(1);
        tree2.root.left = new com.company.dataStructures.implementations.TreeNode(2);
        tree2.root.right = new com.company.dataStructures.implementations.TreeNode(3);
        tree2.root.left.right = new TreeNode(5);

        if (tree.root.val != tree2.root.val) {
            System.out.println("Roots are unequal");
            System.exit(0);
        }

        System.out.println(flipEquiv(tree.root, tree2.root));
    }

}
