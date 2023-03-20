package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            result.add(root.val);
            System.out.print(root.val + "--->");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    public static List<Integer> preorderTraversal_iterative(TreeNode root) {
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
//            result.add(node.val);
            System.out.print(node.val + "--->");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);

//        preorderTraversal(root);
        preorderTraversal_iterative(root);
    }
}
