import com.company.dataStructures.implementations.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class UnionFindScratch {
    public int[] root;
    int[] rank;
    static int count;

    public UnionFindScratch() {

    }

    public UnionFindScratch(int size){
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] =i;
            rank[i] =1;
        }

        count = size;
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
            count--;
//            return true;
        }

//        return false;
    }

    public static void main(String[] args) throws Exception {
        int[][] edges = {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
        int n = 4;
        int minTimestamp = Integer.MAX_VALUE;

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer tsp1 = o1[0];
                Integer tsp2 = o2[0];
                return tsp1.compareTo(tsp2);
            }
        });
        UnionFindScratch uf = new UnionFindScratch(n);

        //1. No separate components, 2. No Cycles.
        for (int[] edge : edges){
          uf.union(edge[1] , edge[2]);
          if(count==1){
              minTimestamp = Math.min(minTimestamp, edge[0]);
              break;
          }
        }
        System.out.println( count ==1? minTimestamp : "No such timestamp is available");
    }
}
