package leetcode.problems.medium;

import com.company.dataStructures.implementations.TreeNode;

import java.util.ArrayList;


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
