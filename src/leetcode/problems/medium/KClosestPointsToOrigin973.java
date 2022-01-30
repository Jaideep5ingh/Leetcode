package leetcode.problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {
    private static int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String args[]) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);


        for (int i=0; i< points.length; i++){
            int[] entry = {squaredDistance(points[i]), i};
            if(priorityQueue.size() < k){
                priorityQueue.add(entry);
            }else if(priorityQueue.peek()[0] > entry[0]){
                priorityQueue.poll();
                priorityQueue.add(entry);
            }
        }
        for (int i = 0; i < k; i++) {
            int entryIndex = priorityQueue.poll()[1];
            System.out.println(Arrays.toString(points[entryIndex]));
        }
    }
}
