package leetcode.problems;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TreeScratch {
//
//    static int leftDepth = 0;
//    static int rightDepth = 0;
    public static int[] treesArray;


    public static void main(String[] args) {
//        TreeNode fifteen = new TreeNode(15);
//        TreeNode seven = new TreeNode(7);
//        TreeNode nine = new TreeNode(9, fifteen, seven);
//        TreeNode twenty = new TreeNode(20);
//        TreeNode root = new TreeNode(3, nine, twenty);

        int n = 4;
        if (n == 0) {
            System.exit(0);
        }
        LinkedList<TreeNode> result =  generate_trees(1, n);
    }

    public static LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
             for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}
