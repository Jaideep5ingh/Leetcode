package GFG;
import com.company.dataStructures.implementations.DsScratch;
//Article Link : https://www.geeksforgeeks.org/binary-tree-array-implementation/?ref=lbp

public class NodesToArrayRepresenationOfBinaryTree_GFG {
    int root = 0;
    String[] treeArray = new String[10];

    public void Root(String root){
        treeArray[this.root] = root;
    }

    public void set_Left(String val, int root){
        if(treeArray[root] == null){
            System.out.println("cannot set value of left child as root is null");
            return;
        }
        int t = 2*root + 1;
        treeArray[t] = val;
    }

    public void set_Right(String val, int root){
        if(treeArray[root] == null){
            System.out.println("cannot set value of right child as root is null");
            return;
        }
        int t = 2*root + 2;
        treeArray[t] = val;
    }

    void print_Tree(){
        for (int i = 0; i < treeArray.length; i++) {
            System.out.print(treeArray[i] == null ? "-" : treeArray[i]);
        }
    }

    public static void main(String[] args) {
        // Creating object of class 2 inside main() method
        NodesToArrayRepresenationOfBinaryTree_GFG obj = new NodesToArrayRepresenationOfBinaryTree_GFG();

        // Setting root node
        obj.Root("A");

        // obj.set_Left("B", 0);
        obj.set_Right("C", 0);
        obj.set_Left("D", 1);
        obj.set_Right("E", 1);
        obj.set_Left("F", 2);
        obj.print_Tree();
    }

}
