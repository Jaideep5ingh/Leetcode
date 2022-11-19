package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class LowestCommonAncestorOfABinaryTree236 {
    static com.company.dataStructures.implementations.TreeNode answer;
    public static boolean lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        int left = lowestCommonAncestor(root.left, p, q) ? 1:0;
        int right = lowestCommonAncestor(root.right, p, q) ? 1:0;
        int mid = (root == p || root == q) ? 1:0;

        if(left + right + mid >=2) answer = root;

        return left + right + mid > 0;
    }
    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.right.left = new TreeNode(0);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(18);

        int p = 5, q = 4;

        lowestCommonAncestor(tree.root, tree.root.left, tree.root.right);
        System.out.println(answer.val);
    }
}
