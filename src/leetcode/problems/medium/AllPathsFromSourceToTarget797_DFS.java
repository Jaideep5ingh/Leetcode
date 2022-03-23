package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget797_DFS {
    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3},{3},{}};
        int n =5;
        List<List<Integer>> paths = new ArrayList<>();

        if(graph == null || graph.length ==0){
            System.exit(0);
        }

        dfs(graph, 0, new ArrayList<Integer>(),paths);
        for (List<Integer> x : paths){
            System.out.println(Arrays.toString(x.toArray()));
        }
    }

    private static void dfs(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode : nextNodes ){
            dfs(graph, nextNode,path, paths);
            path.remove(path.size()-1);
        }
    }
}
