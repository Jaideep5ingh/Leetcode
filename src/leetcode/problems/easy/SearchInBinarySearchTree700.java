package leetcode.problems.easy;

import com.company.dataStructures.implementations.TreeNode;

public class SearchInBinarySearchTree700 {

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode second = new TreeNode(5);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(7);
        TreeNode sixth = new TreeNode(16);

        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = null;
        third.right = sixth;

        TreeNode found = searchBST(root, 16);
        System.out.println(found.val);
    }
}
