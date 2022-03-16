package com.company.dataStructures.implementations;

public class UnionFind_ByRank {
    int[] root;
    int[] rank;

    public UnionFind_ByRank(int size){
        this.rank = new int[size];
        this.root = new int[size];

        for (int i = 0; i < size; i++) {
            this.root[i]= i;
            this.rank[i]=1;
        }
    }

    public int find(int x){
        for (int i = 0; i < this.root.length; i++) {
            while(x!=this.root[i]) {
                x = root[i];
            }
        }
        return x;
    }

    public  void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            if (rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]+=1;
            }
        }
    }

    public boolean connected(int x, int y ){
        return find(x)==find(y);
    }

    public static void main(String[] args) {
        UnionFind_ByRank uf = new UnionFind_ByRank(10);
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
