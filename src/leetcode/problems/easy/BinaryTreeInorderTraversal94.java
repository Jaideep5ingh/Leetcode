package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    static List<Integer> result_inOrder = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            result_inOrder.add(root.val);
            System.out.print(root.val + "--->");
            inorderTraversal(root.right);
        }
        return result_inOrder;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);

        inorderTraversal(root);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
