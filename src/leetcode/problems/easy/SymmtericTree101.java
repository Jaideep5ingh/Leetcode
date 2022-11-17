package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmtericTree101 {

    static boolean symmetricTree_Iterative(TreeNode root){
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        stack.offer(root);
        while(!stack.isEmpty()){
            TreeNode node1 = stack.poll();
            TreeNode node2 = stack.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            stack.offer(node1.left);
            stack.offer(node2.right);
            stack.offer(node1.right);
            stack.offer(node2.left);
        }
        return true;
    }

    static boolean symmetricTree(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return (node1.val == node2.val) && symmetricTree(node1.left, node2.right)
                && symmetricTree(node1.right, node2.left);
    }



    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        System.out.println(symmetricTree_Iterative(tree.root));
    }
}
