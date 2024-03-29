import com.company.dataStructures.implementations.Kruskal;
import com.company.dataStructures.implementations.UnionFind_PathCompression;

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

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Kruskal_my kruskalMy = new Kruskal_my();
        Prim_my primMy = new Prim_my();
        System.out.print("Minimum Cost to Connect Points = ");
        System.out.println(kruskalMy.minCostConnectPoints_Kruskal(points));
        System.out.println(primMy.minCostConnectPoints_Prim(points));
    }
}

class Kruskal_my{
    protected int minCostConnectPoints_Kruskal(int[][] points){
        int result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y) -> x.cost - y.cost);
        int size = points.length;
        int count = size-1;
        UnionFind_PathCompression unionFind = new UnionFind_PathCompression(size);

        for (int i = 0; i < size; i++) {
            int[] coordinates1 = points[i];
            for (int j = 1; j < size; j++) {
                int[] coordinates2 = points[j];
                int cost = Math.abs((coordinates1[0] - coordinates2[0])) +
                        Math.abs((coordinates1[1] - coordinates2[1]));
                Edge edge = new Edge(i,j, cost);
                pq.add(edge);
            }
        }

        while(!pq.isEmpty() && count > 0){
            Edge current = pq.poll();
            int point1 = current.point1;
            int point2 = current.point2;
            if(!unionFind.connected(point1, point2)){
                unionFind.union(point1, point2);
                result+=current.cost;
                count--;
            }
        }

        return result;
    }

    class Edge{
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost){
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }
}

class Prim_my{

    protected int minCostConnectPoints_Prim(int[][] points){
        int result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y) -> x.cost - y.cost);
        int size = points.length;
        int count = size - 1;
        boolean[] visited = new boolean[size];

        int[] coordinate1 = points[0];
        for (int i = 1; i < size; i++) {
            int[] coordinate2 = points[i];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                    Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, i, cost);
            pq.add(edge);
        }
        visited[0]=true;

        while (!pq.isEmpty() && count>0){
            Edge current = pq.poll();
            int point1 = current.point1;
            int point2 = current.point2;
            if(!visited[point2]){
                result+=current.cost;
                visited[point2] = true;
                for (int i = 0; i < size; i++) {
                    if(!visited[i]){
                        int distance = Math.abs(points[point2][0] - points[i][0]) +
                                Math.abs(points[point2][1] - points[i][1]);
                        Edge edge = new Edge(point2, i, distance);
                        pq.add(edge);
                    }
                }
                count--;
            }
        }

        return result;
    }
    class Edge{
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost){
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }
}
