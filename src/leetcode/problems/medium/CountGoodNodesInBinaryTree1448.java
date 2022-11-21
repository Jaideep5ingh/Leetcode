package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class CountGoodNodesInBinaryTree1448 {
    static int count = 0;
    static int goodNodes(com.company.dataStructures.implementations.TreeNode root) {
        helper(root, root.val);
        return count;
    }

    static void helper(com.company.dataStructures.implementations.TreeNode root, int prevMax){
        if(root == null) return;

        if (root.val >= prevMax){
            ++count;
            prevMax = root.val;
        }
        helper(root.left, prevMax);
        helper(root.right, prevMax);
    }

    public static void main(String[] args) {
        DsScratch tree2 = new DsScratch();
        tree2.root = new com.company.dataStructures.implementations.TreeNode(3);
        tree2.root.left = new com.company.dataStructures.implementations.TreeNode(3);
        tree2.root.left.left = new com.company.dataStructures.implementations.TreeNode(4);
        tree2.root.left.right = new TreeNode(2);
        System.out.println(goodNodes(tree2.root));
    }
}
