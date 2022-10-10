package leetcode.problems.medium;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        int numCourse = 4;
        int[][] prereqs = {{3,2},{1,0},{2,0},{3,1}};
        int[] result = new int[numCourse];

        if(numCourse == 0){
//            return result;
            System.exit(0);
        }
        if(prereqs == null || prereqs.length==0){
            for(int i =0 ; i< prereqs.length; ++i){
                result[i] = i ;
            }

//            return result;
            System.exit(0);
        }

        int[] indegree = new int[numCourse];
        Queue<Integer> zeroIndegree = new LinkedList<>();

        for(int[] pre : prereqs){
            indegree[pre[0]]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                zeroIndegree.add(i);
            }
        }

        if(zeroIndegree.isEmpty()) {
//            return new int[0];
            System.exit(0);
        }

        int index = 0;
        while(!zeroIndegree.isEmpty()){
            int course = zeroIndegree.poll();
            result[index] = course;
            index++;

            for(int[] pre : prereqs){
                if(pre[1] == course){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0){
                        zeroIndegree.add(pre[0]);
                    }
                }
            }
        }

        for (int n : indegree) {
            if (n != 0) {

//                return new int[0];
                System.exit(0);
            }
        }
        System.out.println(Arrays.toString(result));
    }

}
