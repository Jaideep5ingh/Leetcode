package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class ConstructStringFromBinaryTree606 {
    static StringBuilder ans = new StringBuilder("");
    static String tree2str(TreeNode root) {
        if(root == null ) return "";
        ans.append(root.val);

        if(root.left == null && root.right == null) return "";
        ans.append("(");
        tree2str(root.left);
        ans.append(")");
        if(root.right!=null){
            ans.append("(");
            tree2str(root.right);
            ans.append(")");
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.right.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(4);
//        tree.root.right.right = new TreeNode(9);
        System.out.println(tree2str(tree.root));
    }
}
