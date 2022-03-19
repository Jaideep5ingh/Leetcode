package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class FindIfAPathExists1971 {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2},{3,5},{5,4},{4,3}};
        int n =5, source = 0, destination = 5;
        int paths = 0;

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();

        stack.push(source);

        //TODO : CREATING THE ADJ LIST OF THE GIVEN GRAPH
        for (int i = 0; i < n; i++) {
            if(!adj.containsKey(edges[i][0])){
                adj.put(edges[i][0], new ArrayList<>());
            }
            adj.get(edges[i][0]).add(edges[i][1]);
        }

//  System.out.println(adj);

        while(!stack.isEmpty()){
            int s = stack.pop();
            if (s==destination){
                System.out.println("The path from the source and destination exists");
                System.exit(0);
            }
            ArrayList<Integer> temp = adj.get(s);

            if(temp!=null){
                for (int x : temp){
                    if(!seen.contains(x)){
                        stack.push(x);
                    }
                }
            }

            seen.add(s);
        }
        System.out.println("The path from the source and destination doesn't exists");
    }
}
