package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals56 {
    public static void main(String[] args){
        int[][] merge = {{1,3}, {2,6},{8,10},{15,18}};
        Arrays.sort(merge, (a, b)->{
            return Integer.compare(a[0],b[0]);
        });

//        for (int[] interval : merge){
//            for (int integer : interval){
//                System.out.println(interval.toString());
//            }
//        }

        for (int i = 0; i <4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(merge[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        ArrayList<int[]> solution = new ArrayList<>();
        //sorting
        for (int i = 0, j=0; i < 3; i++) {
            if (merge[i][j+1] > merge[i+1][j] ){
                solution.add(new int[]{merge[i][j],merge[i+1][j+1]});
                i++;
            }else{
                solution.add(new int[]{merge[i][j],merge[i][j+1]});
            }
            if (i==merge.length-2){
                solution.add(new int[]{merge[merge.length-1][j],merge[merge.length-1][j+1]});
            }
        }

        for (int i[] : solution) {
            System.out.println(Arrays.toString(i));
        }

    }
}
