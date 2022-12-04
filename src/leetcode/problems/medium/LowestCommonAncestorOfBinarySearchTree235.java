package leetcode.problems.medium;

import com.company.dataStructures.implementations.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree235 {

    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q){
        int rootVal= root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(qVal < rootVal && pVal < rootVal){
            return lowestCommonAncestorBST(root.left, p, q);
        }else if(qVal < rootVal && pVal > rootVal){
            return lowestCommonAncestorBST(root.right, p, q);
        }else return root;
    }
}
