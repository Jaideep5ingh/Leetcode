package GFG;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.*;


public class TreeTraversals {
    TreeNode root = new TreeNode();

    static void inOrder_recursion(TreeNode root){
        if(root == null){
            return;
        }

        inOrder_recursion(root.left);
        System.out.print(root.val + " ");
        inOrder_recursion(root.right);
    }

    static void inOrder_Stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");
            if(current.right !=null) stack.push(current.right);
        }
    }

    static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void preOrder_Stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.print(current.val);
            if (current.right!= null ) stack.push(current.right);
            if (current.left!= null ) stack.push(current.left);
        }
    }

    static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    static void postOrder_Stack(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode curr = s1.pop();
            s2.push(curr);
            if(curr.left!=null) s1.push(curr.left);
            if(curr.right!=null) s1.push(curr.right);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().val + " ");
        }

    }

    static void levelOrder(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null)queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    static void morrisInOrder(TreeNode root){
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.val + " ");
                current = current.right;
            }
            else{
                TreeNode prev = current.left;
                while(prev.right != null) prev = prev.right;
                prev.right = current;
                TreeNode temp = current;
                current = current.left;
                temp.left = null;
            }
        }
    }

    static void morrisPreOrder(TreeNode root){
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.val + " ");
                current = current.right;
            }
            else{
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }
                if(prev.right == null){
                    System.out.print(current.val + " ");
                    prev.right = current;
                    current = current.left;
                }
                else{
                    prev.right = null;
                    current = current.right;
                }
            }
        }
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
//        inOrder_recursion(tree.root);
//        System.out.println("");
//        inOrder_Stack(tree.root);
//        System.out.println("");
//        preOrder(tree.root);
//        System.out.println("");
//        levelOrder(tree.root);
//        preOrder_Stack(tree.root);
//        postOrder_Stack(tree.root);
//        System.out.println("");
//        morrisInOrder(tree.root);
        System.out.println("");
        morrisPreOrder(tree.root);
    }
}
