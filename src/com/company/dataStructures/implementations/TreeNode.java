package com.company.dataStructures.implementations;

import com.sun.source.tree.Tree;

import java.sql.ResultSet;
import java.util.*;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void createBinaryTree(TreeNode root){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public static void createBinaryTree(int[] nodes){

    }

    public static void preOrderTraversal(TreeNode root){
        LinkedList<TreeNode> tree = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null){
            System.out.println("There is no root");
        }

        tree.add(root);
        while(!tree.isEmpty()){
            TreeNode node = tree.pollLast();
            output.add(node.val);

            if(node.right!=null){
                tree.add(node.right);
            }if(node.left!=null){
                tree.add(node.left);
            }
        }
        System.out.println("The inorder traversal : " + output.toString());
    }


    public static void inOrderTraversal(TreeNode root){
        Stack<TreeNode> tree = new Stack<>();
        ArrayList<Integer> output = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !tree.isEmpty()){
            while (curr !=null){
                tree.add(curr);
                curr = curr.left;
            }

            curr = tree.pop();
            output.add(curr.val);
            curr = curr.right;

        }
        System.out.println("The inorder traversal : " + output.toString());
    }

    public static void postOrderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            System.out.println("Root is null");
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(0, cur.val);
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }
        System.out.println("The inorder traversal : " + list.toString());
    }

    public static void BFS(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> tree = new LinkedList<>();

        if(root==null) System.out.println("Root is empty");

        tree.add(root);
        int level =0;
        while(!tree.isEmpty()){
            result.add(new ArrayList<>());
            int level_length = tree.size(); // This is stored as a variable because when we add child nodes, tree.size() changes and should not be used directly in loop conditional
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = tree.remove();

                result.get(level).add(node.val);

                if (node.left != null) tree.add(node.left);
                if (node.right != null) tree.add(node.right);
            }
            level++;
        }
        System.out.println("BFS : " + result.toString());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
//
//        preOrderTraversal(root);
//        inOrderTraversal(root);
//        postOrderTraversal(root);

        BFS(root);

    }
}
