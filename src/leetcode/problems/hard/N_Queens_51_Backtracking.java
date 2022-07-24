package leetcode.problems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N_Queens_51_Backtracking {
    private static int size;
    private static List<List<String>> result = new ArrayList<List<String>>();

    public static void main(String[] args) {
        int n = 4;
        size = n;
        char[][] state = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                state[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>() , new HashSet<>() , new HashSet<>(), state);

        for (List<String> l : result){
            System.out.print("[");
            for (String s : l){
                System.out.print(" ");
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println("]");
        }

    }

    private static List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }

        return board;
    }

    public static void backtrack(int row, Set<Integer> cols, Set<Integer> Diagonal, Set<Integer> antiDiagonal,
                                 char[][] state){
        if(row == size){
            result.add(createBoard(state));
            return;
        }

        for(int col = 0; col < size ; ++col){
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;

            if(Diagonal.contains(currentDiagonal) || antiDiagonal.contains(currentAntiDiagonal) || cols.contains(col)){
                continue;
            }

            cols.add(col);
            Diagonal.add(currentDiagonal);
            antiDiagonal.add(currentAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row +1, cols, Diagonal, antiDiagonal, state);

            cols.remove(col);
            Diagonal.remove(currentDiagonal);
            antiDiagonal.remove(currentAntiDiagonal);
            state[row][col] = '.';
        }
    }
}
