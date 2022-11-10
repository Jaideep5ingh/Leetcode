package GFG;


//Quesiton Link : https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/

import com.company.dataStructures.implementations.DsScratch;
import com.company.dataStructures.implementations.TreeNode;

public class BinaryTreeFromParentRepresenationArray_GFG {
    TreeNode root;
    public TreeNode createTree(int[] parent, int nodes){
        TreeNode[] created = new TreeNode[nodes];
        for (int i = 0; i < nodes; i++) {
            created[i] = null;
        }
        for (int i = 0; i < nodes; i++) {
            createNode(parent, i, created);
        }
        return root;
    }

    void createNode(int[] parent, int i, TreeNode[] created){
        if(created[i] != null) return;

        created[i] = new TreeNode(i);

        if(parent[i] == -1) {
            root = created[i];
            return;
        }

        if(created[parent[i]] == null){
            createNode(parent, parent[i], created);
        }

        TreeNode p = created[parent[i]];
        if(p.left == null) p.left = created[i];
        else p.right = created[i];
    }

    // Utility function to do inorder traversal
    static void inorder(TreeNode node)
    {
        if (node != null)
        {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeFromParentRepresenationArray_GFG tree = new BinaryTreeFromParentRepresenationArray_GFG();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        TreeNode node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
    }
}
