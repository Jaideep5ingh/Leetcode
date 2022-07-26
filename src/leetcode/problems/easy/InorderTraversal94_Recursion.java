package leetcode.problems.easy;

import java.util.ArrayList;

//Definition for a binary tree node.
class TreeNode {
    public int val;
    public leetcode.problems.TreeNode left;
    public leetcode.problems.TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, leetcode.problems.TreeNode left, leetcode.problems.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InorderTraversal94_Recursion {
    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9, seven, fifteen);
        TreeNode twentyOne = new TreeNode(21);
        TreeNode root = new TreeNode(3, nine, twentyOne);

//        TreeNode one1 = new TreeNode(1, null, null);
//        TreeNode three1 = new TreeNode(3);
//        TreeNode root1 = new TreeNode(2, one1, three1);

//        TreeNode one2 = new TreeNode(1, null, null);
//        TreeNode three2 = new TreeNode(3);
//        TreeNode root2 = new TreeNode(2, one2, three2);

        ArrayList<Integer> result = inorderTraversal(root);

        System.out.println(result);

    }
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }

    public static void helper(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);

    }
}
