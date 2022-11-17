package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

public class PathSum112_Iterative {
    static boolean pathSum(TreeNode node, int target){
        if (node == null)
            return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(node, target - node.val));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode tempNode = pair.getKey();
            int sum = pair.getValue();

            if ((tempNode.right == null) && (tempNode.left == null) && (sum == 0))
                return true;

            if(tempNode.right != null){
                stack.push(new Pair<>(tempNode.right, sum - tempNode.right.val));
            }
            if(tempNode.left != null){
                stack.push(new Pair<>(tempNode.left, sum - tempNode.left.val));
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.right.left = new TreeNode(13);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);

        int targetSum= 22;
        System.out.println(pathSum(tree.root, targetSum));
    }
}
