package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FindIfAPathExists1971_BFS {
    public static void main(String[] args) {
        int[][] edges = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        int n=10, source = 7, destination = 5;

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            if (!adjList.containsKey(edges[i][0])){
                adjList.put(edges[i][0], new ArrayList<>());
            }
            adjList.get(edges[i][0]).add(edges[i][1]);

            if (!adjList.containsKey(edges[i][1])){
                adjList.put(edges[i][1], new ArrayList<>());
            }
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        queue.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();
            seen.add(node);
            temp = adjList.get(node);
            if(temp!=null){
                for (int i: temp){
                    if (i==destination){
                        System.out.println("Path exists");
                        System.exit(0);
                    }
                    if(!seen.contains(i)){
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println("Path doesn't exist");
    }
}
