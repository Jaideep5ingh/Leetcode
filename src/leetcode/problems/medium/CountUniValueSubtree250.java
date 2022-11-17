package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class CountUniValueSubtree250 {
    static int count=0;

    static boolean countUnivalSubtrees(TreeNode root){
        if(root.left == null && root.right == null){
            count++;
            return true;
        }
        boolean is_uni = true;

        if(root.left!=null){
            is_uni = countUnivalSubtrees(root.left) && is_uni && root.val == root.left.val;
        }

        if(root.right!=null){
            is_uni = countUnivalSubtrees(root.right) && is_uni && root.val == root.right.val;
        }
        if(!is_uni) return false;
        count++;
        return true;
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.left = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.right = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.left.left = new com.company.dataStructures.implementations.TreeNode(1);
        tree.root.right.left = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.left.right = new com.company.dataStructures.implementations.TreeNode(5);
        tree.root.right.right = new TreeNode(5);
        countUnivalSubtrees(tree.root);
        System.out.println(count);
    }
}
