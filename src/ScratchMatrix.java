import java.util.Stack;

public class ScratchMatrix {
 public static void main(String[] args) {
  String[][] board = {{"A","B","C","E"},
          {"S","F","C","S"}};

  String word = "ABCCED";

//  char[] wordToChar = word.toCharArray();

//  int[][] board =
//      {{1,0}};

  int rows = board.length;
  int cols = board[0].length;

  for(int i = 0 ; i<rows; ++i){
   char wordChar = word.charAt(0);
   for (int j = 0; j < cols; j++) {
    if (board[i][j].equals(String.valueOf(wordChar))){
     findWord(word, i, j, board);
    }
   }
   }

//  System.out.println("Island Perimeter : "  + count);

//  for (int i = 0; i < rows; i++) {
//   for (int j = 0; j < rows; j++) {
//    System.out.print(board[i][j]);
//    System.out.print(" ");
//   }
//   System.out.println();
//  }
 }

 private static void findWord(String word, int i, int j, String[][] board) {
  int count = 1;

  Stack<String> stack = new Stack<>();
  stack.push(board[i][j]);

  while(!stack.isEmpty()){
//   String current = stack.pop();
   if (i-1>=0){
    if (board[i-1][j].equals(word.charAt(count))){
     stack.push(board[i-1][j]);
    }
   } if (i+1<board.length){
    if (board[i+1][j].equals(word.charAt(count))){
     stack.push(board[i+1][j]);
    }
   } if (j-1>=0){
    if (board[i][j-1].equals(word.charAt(count))){
     stack.push(board[i][j-1]);
    }
   } if (j+1<board[0].length){
    if (board[i][j+1].equals(word.charAt(count))){
     stack.push(board[i][j+1]);
    }
   }
   count++;
  }
  System.out.println(count == word.length() ? true: false);
 }
}
