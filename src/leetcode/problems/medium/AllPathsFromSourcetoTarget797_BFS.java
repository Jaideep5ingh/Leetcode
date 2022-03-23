package leetcode.problems.medium;

import java.util.*;

public class AllPathsFromSourcetoTarget797_BFS {
    public static void main(String[] args) {
        int[][] edges = {{0,0,0},{1,1,0},{1,1,0}};
        int n = edges.length;
        int source = 0, destination = n-1;

        Queue<List<Integer>> queue = new LinkedList<>();
        boolean[] seen = new boolean[n];
        List<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        queue.add(Arrays.asList(source));

        while(!queue.isEmpty()){
            path = queue.poll();
            if (path.get(path.size() - 1) == destination){
                paths.add(new ArrayList<>(path));
            }
            else{
                int[] adjacentNodes = edges[path.get(path.size() - 1)];
                for (int i : adjacentNodes){
                    List<Integer> temp = new ArrayList<>(path);
                    temp.add(i);
                    queue.add(temp);
                }
            }
        }
        System.out.println(paths);
    }
}
