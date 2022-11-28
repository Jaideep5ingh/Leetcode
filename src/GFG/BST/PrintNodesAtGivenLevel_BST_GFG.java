package GFG.BST;

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.company.dataStructures.implementations.DsScratch.bst_insert;

public class PrintNodesAtGivenLevel_BST_GFG {

    public static void printLevel(TreeNode root, int level){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode curr = null;
        int currLevel = 0;

        while (!queue.isEmpty())
        {
            currLevel++;
            int size = queue.size();
            while (size-- > 0)
            {
                curr = queue.poll();
                if (currLevel == level) {
                    System.out.print(curr.val + " ");
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
//        <=============BST Trees===============>
        DsScratch tree = new DsScratch();
        tree.root = null;
        tree.root = bst_insert(tree.root, 5);
        bst_insert(tree.root, 8);
        bst_insert(tree.root, 3);
        bst_insert(tree.root, 7);
        bst_insert(tree.root, 1);
        bst_insert(tree.root, 4);

        printLevel(tree.root, 2);
    }
}
