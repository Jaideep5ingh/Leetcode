package leetcode.problems.medium;

import com.company.dataStructures.implementations.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal106 {
    static int preOrderIndex = 0;
    static HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    static TreeNode arrayToTree(int[] preOrder, int left, int right){
        if(left > right) return null;

        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.right = arrayToTree(preOrder, inOrderMap.get(rootVal)+1, right);
        root.left = arrayToTree(preOrder, left, inOrderMap.get(rootVal) - 1);


        return root;
    }
    static void inOrder_recursion(TreeNode root){
        if(root == null){
            return;
        }

        inOrder_recursion(root.left);
        System.out.print(root.val + " ");
        inOrder_recursion(root.right);
    }
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3}, inorder = {9, 3, 15, 20, 7};
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        inOrder_recursion(arrayToTree(postorder, 0, postorder.length - 1));
    }
}
