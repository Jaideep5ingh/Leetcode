package leetcode.problems.medium;

import java.util.Arrays;

public class Minesweeper_WIP {
    public static void main(String[] args) {
        char[][] board ={{'E','E','E','E','E'},{'E','E','E','M','E'},{'E','E','E','E','M'},{'E','E','E','E','E'}};
        char[][] auxBoard = new char[board.length+2][5+2];
        for (int i = 1; i < board.length+1; i++) {
            for (int j = 1; j < 6; j++) {
                auxBoard[i][j] = board[i-1][j-1];
            }
        }
//  for (char[] character : auxBoard ){
//   System.out.println(Arrays.toString(character));
//  }

        int[] click = {1,3};
        if (board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            System.out.println("GAME OVER");
            for (char[] character : board ){
                System.out.println(Arrays.toString(character));
            }
            System.exit(0);
        }else{
            spreadBoard(board, auxBoard,click[0],click[1] );
        }
    }

    private static void spreadBoard(char[][] board,char[][] auxBoard, int m, int n) {
        if(!checkMine(board,auxBoard,m,n)){
            spreadBoard(board,auxBoard,m,n);
        }
    }

    private static boolean checkMine(char[][] board, char[][] auxBoard, int m, int n) {
        //check boundaries
        int count = 0;
        for (int i = m-1; i <= m+1; i++) {
            for (int j = n-1; j <= n+1; j++) {
                if(auxBoard[i+1][j+1] == 'M'){
                    count++;
                }
            }
        }if (count>0) {
            board[m][n] = Character.forDigit(count,10);
            return true;
        }
        else {
            board[m][n] = 'B';
            return false;
        }
    }
}
