package leetcode.problems;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TreeScratch {

    static TreeNode first = null;
    static TreeNode last = null;

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);

//        TreeNode one1 = new TreeNode(1, null, null);
//        TreeNode three1 = new TreeNode(3);
//        TreeNode root1 = new TreeNode(2, one1, three1);

//        TreeNode one2 = new TreeNode(1, null, null);
//        TreeNode three2 = new TreeNode(3);
//        TreeNode root2 = new TreeNode(2, one2, three2);

        TreeNode first = convert(root);

        TreeNode current = first;

        do{
            System.out.print(current.val);
            System.out.print("-->");
            current = current.right;
        }while(current.val != 5);

        System.out.print("-->");
        System.out.print(current.val);

    }
    public static TreeNode convert(TreeNode root){

        if(root == null) {
            return null;
        }

        helper(root);

        first.left = last;
        last.right = first;

        return first;
    }

    public static void helper(TreeNode node){
        if (node!= null){
            helper(node.left);

            if(last != null){
                last.right = node;
                node.left = last;
            }else{
                first = node;
            }
            last = node;

            helper(node.right);
        }
    }

}
