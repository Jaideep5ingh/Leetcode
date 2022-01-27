package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public static void main(String args[]) {
        int[][] intervals = {{0,30},{15,20},{5,10}};

        PriorityQueue<Integer> allocation = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        allocation.add(intervals[0][1]);

        for (int i = 0; i < intervals.length; i++) {
            if(allocation.peek() <= intervals[i][1]){
                allocation.poll();
            }

            allocation.add(intervals[i][1]);
        }

        for (int[] i : intervals){
            System.out.println(Arrays.toString(i));
        }

        System.out.println("Result : " + allocation.size());

    }
}
