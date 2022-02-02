package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int up = 0; int down = matrix.length-1; //number of rows
        int left = 0, right = matrix[0].length-1; //number of columns and how to calculate it.
        List<Integer> result = new ArrayList<>();
        while (result.size() < (matrix.length) * (matrix[0].length)) {
            //left to right
            for (int cols = left; cols <= right; cols++) {
                result.add(matrix[up][cols]);
            }
            //up to down
            for (int row = up+1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            //check if up!= down, then go from right to left
            if (up!=down) {
                for (int cols = right - 1; cols >= left; cols--) {
                    result.add(matrix[down][cols]);
                }
            }
            //check if right!= left, then go from left to right
            if(left!=right){
                for (int row = down-1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
    }
}
