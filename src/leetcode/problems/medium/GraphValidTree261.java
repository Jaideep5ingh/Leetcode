package leetcode.problems.medium;

import com.company.dataStructures.implementations.UnionFind_UnionBoolean;

public class GraphValidTree261 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{1,3},{1,4},{2,3}};
        int n=5;

        UnionFind_UnionBoolean unionFind = new UnionFind_UnionBoolean(n);

        for (int i = 0; i < edges.length; i++) {
            if(!unionFind.union(edges[i][0], edges[i][1])){
                System.out.println("Invalid Tree");
                System.exit(0);
            }
        }
        System.out.println("Valid Tree");
    }
}
