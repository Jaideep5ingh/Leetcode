package leetcode.problems.easy;

public class ToeplitzMatrix766 {
    public static void main(String[] args) {
        int[][] matrix =
                {{1,2,3,4,5},
                        {5,1,2,3,4},
                        {9,5,1,2,3},
                        {9,9,5,1,2}};
//  int[][] matrix =
//                  {{2,1},
//                   {2,2}};

        int rows = matrix.length;
        int cols = matrix[0].length;
//  int[] result =

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = i; k < rows-1 && j < cols -1; k++) {
                    if(matrix[k][j] != matrix[k+1][j+1]){
                        System.out.println("It ain't");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("It sure is!");
    }
}
