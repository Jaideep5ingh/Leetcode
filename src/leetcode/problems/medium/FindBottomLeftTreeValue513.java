package leetcode.problems.medium;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class FindBottomLeftTreeValue513 {
    static int maxLevel = 0;
    static int ans = 0;

    private static void dfs(com.company.dataStructures.implementations.TreeNode root, int level) {
        if (root != null) {

            //if the current level is greater then the global variable level, we update the leftMost
            if (level > maxLevel) {
                maxLevel = level ;
                ans = root.val ;
            }

            //recursive call on the left with level + 1, since the child is on the level which is greater by 1
            if (root.left != null)
                dfs(root.left, level + 1) ;

            //similarly, recursive call on the right child
            if (root.right != null)
                dfs(root.right, level + 1) ;
        }
    }

    public static void main(String[] args) {
        DsScratch tree = new DsScratch();
        tree.root = new com.company.dataStructures.implementations.TreeNode(1);
        tree.root.left = new TreeNode(1);
//        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.left.right = new TreeNode(1);
//        tree.root.right.left = new TreeNode(5);
//        tree.root.right.right = new TreeNode(6);
//        tree.root.right.left.left = new TreeNode(7);
//        findBottomLeftValue(tree.root, 0);
        dfs(tree.root, 0);
        System.out.println(ans);
    }
}
