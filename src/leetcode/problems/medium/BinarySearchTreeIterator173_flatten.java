package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator173_flatten {
    List<TreeNode> array;
    int iterator;

    public BinarySearchTreeIterator173_flatten(TreeNode root) {
        array = new ArrayList<>();
        iterator = -1;
        inOrder_recursion(root);
    }

    public void inOrder_recursion(TreeNode root){
        if(root == null){
            return;
        }

        inOrder_recursion(root.left);
        array.add(root);
        inOrder_recursion(root.right);
    }

    public int next() {
        return array.get(++iterator).val;
    }

    public boolean hasNext() {
        return iterator > array.size()-1;
    }
}
