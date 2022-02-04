package leetcode.problems.easy;

public class FindWinnerOnATicTacToeGame1275 {
    public static void main(String[] args) {
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        int n = 3;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag= 0;

        int player = 1;
        for (int[] move : moves){
            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;

            if (row == col){
                diag += player;
            }

            if (row + col == n - 1){
                antiDiag += player;
            }

            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
                    || Math.abs(diag) == n || Math.abs(diag) == n){
                System.out.println( player == 1 ? "A" : "B");
                //Ideally this should be a return statement if a player has won.
                break;
            }

            player *=-1;
        }
        System.out.println(moves.length == n * n ? "Draw" : "Pending");
    }
}
