package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator173_stack {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator173_stack(TreeNode root) {
        stack = new Stack<>();
        helper(root);
    }

    public void helper(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null){
            helper(node.right);
        }
        return node.val;

    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}
