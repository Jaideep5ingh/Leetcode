package GFG;

import com.company.dataStructures.implementations.TreeNode;

public class MaximumDepthOfABinaryTree_GFG {

    static int maxDepth_recusrion(TreeNode root){
        if (root == null) return 0;
        int maxDepth = 1 + Math.max(maxDepth_recusrion(root.left), maxDepth_recusrion(root.right));
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);
        System.out.println(maxDepth_recusrion(tree.root) - 1); //Counting number of edges and not number of nodes
    }
}
