package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix1091 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] directions ={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] ==1) System.exit(0);

//  int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1}); //third number is the steps counter
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] point = queue.poll();

                if(point[0] == m-1 && point[1]==n-1){
                    System.out.println("Path found");
                    System.out.println(point[2]);
                    System.exit(0);
                }
                for (int[] d : directions){
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] ==0){
                        queue.add(new int[]{r,c, point[2]+1});
                        grid[r][c]=1;
                    }
                }
            }
        }
        System.out.println("No path found");
    }
}
