package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ParallelCourses1136 {
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1,3},{2,3}};
        if(n==0){
            System.exit(0);
        }

        if(relations == null || relations.length == 0){
            System.exit(0);
        }

        int[] indegree = new int[n+1];
        Queue<Integer> zeroIndegree = new LinkedList<>();

        for(int[] rel : relations){
            indegree[rel[1]]++;
        }
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0){
                zeroIndegree.add(i);
            }
        }

        if(zeroIndegree.isEmpty()) System.exit(0);

        int step = 0 ;
        int studied= 0;

        while(!zeroIndegree.isEmpty()){
            step++;
            Queue<Integer> nextQueue = new LinkedList<>();
            for (int node : zeroIndegree){
                studied++;
                for(int[] rel : relations){
                    if(rel[0] == node){
                        indegree[rel[1]]--;
                        if(indegree[rel[1]] ==0){
                            nextQueue.add(rel[1]);
                        }
                    }
                }
            }
            zeroIndegree = nextQueue;
        }
        System.out.println(studied==n?step : -1);
    }
}
