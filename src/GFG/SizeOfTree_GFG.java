package GFG;

import com.company.dataStructures.implementations.TreeNode;

//Going with recursion here since it is just 3 lines of codes
// and easy to understand.

public class SizeOfTree_GFG {

    static int size_recursion(TreeNode root){
        if(root == null) return 0;
        else return 1 + size_recursion(root.left) + size_recursion(root.right);
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(7);
        System.out.println(size_recursion(tree.root));
    }
}
