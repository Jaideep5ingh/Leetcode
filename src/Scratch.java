import java.util.*;

public class Scratch {
    public int[] root;
    int[] rank;
    int count = 0;

    public Scratch(int size){
        root = new int[size];
        rank = new int[size];
        count = size;

        for (int i = 0; i < size; i++) {
            root[i] =i;
            rank[i] =1;
        }
    }

    public int find(int x){
        if(x==root[x]){
            return x;
        }
        return root[x] = find(root[x]);
//        while(x!=root[x]){
//            x = root[x];
//        }
//        return x;
    }

    public boolean connected(int x, int y){
        return find(x)==find(y);
    }

    public void union(int x, int y){
        int rootX= find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
            --count;
        }
    }

    static int source = 0;
    static int destination = 2;
    static int n = 3;

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        //create distance matrix
        //sort each row of this matrix while iterating
        //keep picking the smallest edge but would this guarantee a spanning tree?
        


    }
}

