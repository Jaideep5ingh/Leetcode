package leetcode.problems.medium;

public class NumberOfConnectedComponentsInAnUndirectedGraph323_UnionFind {
    public int[] root;
    int[] rank;
    static int count;

    public NumberOfConnectedComponentsInAnUndirectedGraph323_UnionFind() {

    }

    public NumberOfConnectedComponentsInAnUndirectedGraph323_UnionFind(int size){
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

    public static boolean isValid(){
        if (count !=1 ) return false;
        return true;
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
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] edges = {{0,1},{1,2},{0,2},{3,4}};
        int n = 5;
        NumberOfConnectedComponentsInAnUndirectedGraph323_UnionFind uf = new NumberOfConnectedComponentsInAnUndirectedGraph323_UnionFind(n);

        //1. No separate components, 2. No Cycles.
        for (int[] edge : edges){
            uf.union(edge[0] , edge[1]);
        }
        System.out.println(count);
    }
}
