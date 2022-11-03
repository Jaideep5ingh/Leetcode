package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Question very similar to https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3954/
//in terms of overall execution - need 2 queues, main queue points to the new at the end of each iteration,
// level is incremented at the beginning of outer loop.

public class PerfectSquares279 {
    public static void main(String[] args) {
        int n= 17;
        List<Integer> squares = new ArrayList<>();
        Set<Integer> queue = new HashSet<>();

        //Create squares list
        for (int i = 0; i * i <=n ; i++) {
            squares.add(i*i);
        }
        int level = 0;
        queue.add(n);
        while(!queue.isEmpty()){
            level++;
            Set<Integer> newQueue = new HashSet<>();
            for(int remainder : queue){
                for(int square : squares){
                    if(remainder == square){
                        System.out.println("Number of perfect squares needed : " + level);
                        System.exit(0);
                    }
                    else if(remainder < square) break;
                    else{
                        newQueue.add(remainder - square);
                    }
                }
                queue = newQueue;
            }
        }
        System.out.println("Number of perfect squares needed : " + level);
    }
}
