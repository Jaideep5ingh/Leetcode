package leetcode.problems.medium;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {


        TreeNode one = new TreeNode(1, null, null);
        TreeNode three = new TreeNode(3);
        TreeNode root = new TreeNode(2, one, three);

        System.out.println(checkValidBinaryTree(root, null, null));
    }

    public static boolean checkValidBinaryTree(TreeNode root, Integer low,Integer high ){

        if(root == null){
            return true;
        }

        if((low!=null && root.val <= low) || (high!=null && root.val >= high)){
            return false;
        }

        return checkValidBinaryTree(root.left, low, root.val) && checkValidBinaryTree(root.right, root.val, high);
    }
}
