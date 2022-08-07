package leetcode.problems.medium;

import com.company.dataStructures.implementations.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces547_UnionFind {
    public int[] root;
    int[] rank;

    public NumberOfProvinces547_UnionFind(int size){
        root = new int[size];
        rank = new int[size];

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
    }

    public boolean connected(int x, int y){
        return find(x)==find(y);
    }

    public void union(int x, int y){
        int rootX= find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if (rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        Set<Integer> result = new HashSet<>();
        NumberOfProvinces547_UnionFind uf = new NumberOfProvinces547_UnionFind(isConnected.length);

        for (int i =0 ; i< isConnected.length; ++i){
            for (int j =0 ; j< isConnected.length; ++j){
                if(isConnected[i][j] == 1 && i!=j){
                    uf.union(i, j);
                }
            }
        }

        for (int i =0; i < uf.root.length; ++i){
            int x = uf.find(i);
            if(!result.contains(x)){
                result.add(x);
            }
        }

        System.out.println(result.size());
    }
}
