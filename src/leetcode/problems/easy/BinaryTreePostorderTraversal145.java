package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    static List<Integer> result_postOrder = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result_postOrder.add(root.val);
            System.out.print(root.val + "--->");
        }
        return result_postOrder;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);

        postorderTraversal(root);
    }
}
