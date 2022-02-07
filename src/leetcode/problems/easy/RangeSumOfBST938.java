package leetcode.problems.easy;

import com.company.dataStructures.implementations.TreeNode;

import java.util.Stack;

public class RangeSumOfBST938 {
    public static void main(String[] args) {
        int L = 7, H = 15;
        TreeNode root = new TreeNode(10);
        TreeNode second = new TreeNode(5);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(7);
        TreeNode sixth = new TreeNode(15);

        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = null;
        third.right = sixth;

        DFS(root,L,H);
    }

    public static void DFS(TreeNode root, int L , int H){
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (current != null){
                if(L<=current.val && current.val <= H){
                    sum+= current.val;
                }
                if(L< current.val){
                    stack.push(current.left);
                }
                if(current.val < H){
                    stack.push(current.right);
                }
            }
        }
        System.out.println(sum);
    }
}
