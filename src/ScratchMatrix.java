import java.util.*;

public  class ScratchMatrix {
    // box size
    public static int n = 3;// row size
    public static int N = n * n;

    public static int [][] rows = new int[N][N + 1];
    public static int [][] columns = new int[N][N + 1];
    public static int [][] boxes = new int[N][N + 1];

    public static char[][] board =
            {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};;

    public static boolean sudokuSolved = false;

    public static void main(String[] args) {
//    int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,20},{18,21,23,26,30}};

     // init rows, columns and boxes
     for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
             char num = board[i][j];
             if (num != '.') {
                 int d = Character.getNumericValue(num);
                 placeNumber(d, i, j);
             }
         }
     }
     backtrack(0, 0);

//     for(char[] c : board){
//         System.out.print("[");
//         for(char character : c){
//             System.out.print(c);
//             System.out.print(" ");
//         }
//         System.out.println();
//     }
//        System.out.print("]");
 }

// public static  void solveSudoku(String[][] board, int row, HashMap<String, HashSet<String>> cols,
//                                HashMap<String, HashSet<String>> rows,
//                                HashMap<String, HashSet<String>> grid){
//     if(row == size){
//         //DECIDE WHAT TO DO
//         return;
//     }
//
//     for(int col = 0; col< size ; ++col){
//         if (board[row][col] != "."){
//             HashSet<String> add;
//             if(rows.get(row) != null){
//                 add = new HashSet<>();
//             }else{
//                 add = rows.get(row);
//             }
//             add.add(board[row][col]);
//             rows.put(String.valueOf(row), );
//         }
//     }
//
//
//     //When we get to a column with a "." as the String, we would inset a number and proceed to next row and keep on inserting numbers
//     // until we find a condition where out solution break, and then we back track to the first element we inserted.
// }

    public static  boolean couldPlace(int d, int row, int col) {
    /*
    Check if one could place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public static  void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public static  void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public static  void placeNextNumbers(int row, int col) {
    /*
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public static  void backtrack(int row, int col) {
    /*
    Backtracking
    */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        }
        else placeNextNumbers(row, col);
    }
}
