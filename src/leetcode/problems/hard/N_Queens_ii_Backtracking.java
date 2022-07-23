package leetcode.problems.hard;

import java.util.HashSet;
import java.util.Set;

public class N_Queens_ii_Backtracking {
    private static int size;

    public static void main(String[] args) {
        int n = 4;
        size = n;
        System.out.println(backtrack(0, new HashSet<>() , new HashSet<>() , new HashSet<>()));
    }

    public static int backtrack(int row, Set<Integer> cols, Set<Integer> Diagonal, Set<Integer> antiDiagonal){
        if(row == size){
            return 1;
        }
        int solutions = 0;
        for(int col = 0; col < size ; ++col){
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;

            if(Diagonal.contains(currentDiagonal) || antiDiagonal.contains(currentAntiDiagonal) || cols.contains(col)){
                continue;
            }

            cols.add(col);
            Diagonal.add(currentDiagonal);
            antiDiagonal.add(currentAntiDiagonal);

            solutions += backtrack(row +1, cols, Diagonal, antiDiagonal);

            cols.remove(col);
            Diagonal.remove(currentDiagonal);
            antiDiagonal.remove(currentAntiDiagonal);

        }

        return solutions;
    }

}
