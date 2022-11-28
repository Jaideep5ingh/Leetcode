package leetcode.problems.easy;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108 {

    static int[] nums = {-10,-3,0,5,9};
    public static TreeNode sortedArrayToBST(int left, int right) {
        if(left > right) return null;

        int middle = (left + right)/2;

        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(left, middle - 1);
        root.right = sortedArrayToBST(middle + 1, right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode rootFromArray = sortedArrayToBST(0, nums.length - 1);
        DsScratch.inOrder_recursion(rootFromArray);
    }
}
