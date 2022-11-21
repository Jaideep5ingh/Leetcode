package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class SumRootToLeafNumbers129 {
    static int ans = 0;
    static void sumNumbers(com.company.dataStructures.implementations.TreeNode root, int currNum){
        if(root == null) return;
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){
            ans += currNum;
            return;
        }
        sumNumbers(root.left, currNum);
        sumNumbers(root.right, currNum);
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new com.company.dataStructures.implementations.TreeNode(4);
        tree.root.left = new com.company.dataStructures.implementations.TreeNode(9);
        tree.root.right = new com.company.dataStructures.implementations.TreeNode(0);
        tree.root.left.left = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.left.right = new TreeNode(1);
        sumNumbers(tree.root, 0);
        System.out.println(ans);
    }
}
