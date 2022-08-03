package com.company.dataStructures.implementations;

public class UnionFind {
    public int[] root;
    int[] rank;

    public UnionFind() {
    }

    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] =i;
            rank[i] =1;
        }
    }

//    TODO: Find function in quick find
//    public static int find(int x){
//        return root[x];
//    }

    public int find(int x){
        if(x==root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }

    public boolean connected(int x, int y){
        return find(x)==find(y);
    }


//    TODO: Simple Union function where we just set the parent of y as x
//    TODO: Implementing “disjoint sets” - https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3881/

//    public static void union(int x, int y){
//        int parentX = root[x];
//        int parentY = root[y];
//        root[y] = parentX; //Setting x as parent of y.
//    }


//    TODO: Union function in quick find
//    public static void union(int x, int y){
//        int parentX = find(x);
//        int parentY = find(y);
//        root[y] = parentX; //Setting x as parent of y.
//        This step can be skipped as it will be taken care
//        by the loop
//
//        //Extra Step
//        for (int i = 0; i < root.length; i++){
//            if (root[i] == parentY){
//                root[i] = parentX;
//            }
//        }
//    }


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
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
