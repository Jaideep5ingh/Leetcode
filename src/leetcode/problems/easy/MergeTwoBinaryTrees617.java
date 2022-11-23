package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class MergeTwoBinaryTrees617 {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return null;
        if(root1!=null && root2==null) return root1;
        if(root1==null && root2!=null) return root2;
        if(root1 !=null && root2 != null ) root1.val += root2.val;
        root1.left = (mergeTrees(root1.left, root2.left));
        root1.right = (mergeTrees(root1.right, root2.right));
        return root1;
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(5);
//        tree.root.left.right = new TreeNode(1);
//        tree.root.right.left = new TreeNode(5);
//        tree.root.right.right = new TreeNode(6);
//        tree.root.right.left.left = new TreeNode(7);
//        findBottomLeftValue(tree.root, 0);

        DsScratch tree2 = new DsScratch();
        tree2.root = new TreeNode(2);
        tree2.root.left = new TreeNode(1);
        tree2.root.right = new TreeNode(3);
//        tree2.root.left.left = new TreeNode(4);
//        tree2.root.right.left = new TreeNode(1);
        tree2.root.left.right = new TreeNode(4);
        tree2.root.right.right = new TreeNode(7);

        mergeTrees(tree.root, tree2.root);

        DsScratch.inOrder_recursion(tree.root);
    }
}
