package leetcode.problems.medium;

import java.util.Arrays;

public class DiagonalTraverse498 {
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int N = mat.length;
        int M = mat[0].length;

        int[] result = new int[N*M];
        int counter = 0, direction = 1; //1= up and 0 = down
        int row = 0, column = 0;
        while(row < N && column < M){
            result[counter++] = mat[row][column];

            int new_row = row + (direction == 1 ? -1 : 1);
            int new_col = column + (direction == 1 ? 1: -1);

            if(new_row < 0 || new_row == N || new_col < 0 || new_col == M){
                if(direction==1){
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);
                }else{
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }
                direction = 1-direction;
            }else{
                row = new_row;
                column = new_col;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
}
