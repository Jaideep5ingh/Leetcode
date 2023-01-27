package leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku36 {
    /* THE CODE IN THE SECTION IS MY FIRST SOLUTION
    ==============================================
     */
    public static boolean isValidSudoku_MY(char[][] board) {
        Map<Character, Integer[]> rowMap = new HashMap<>();
        Map<Character, Integer[]> colMap = new HashMap<>();
        Map<Character, Integer[]> gridMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    if(!addToMap(rowMap, c, i)) return false;
                    if(!addToMap(colMap, c, j)) return false;
                    if(!addToGridMap(gridMap,c,i,j)) return false;
                }
            }
        }
//        for (Map.Entry<Character , Integer[]> entry : rowMap.entrySet()){
//            System.out.println("For key : "  + entry.getKey() + " rows are : " + Arrays.toString(entry.getValue()));
//        }
//        System.out.println(" ");
//        for (Map.Entry<Character , Integer[]> entry : colMap.entrySet()){
//            System.out.println("For key : "  + entry.getKey() + " cols are : " + Arrays.toString(entry.getValue()));
//        }
//        System.out.println(" ");
//        for (Map.Entry<Character , Integer[]> entry : gridMap.entrySet()){
//            System.out.println("For key : "  + entry.getKey() + " grid are : " + Arrays.toString(entry.getValue()));
//        }

        return true;
    }

    public static boolean addToMap(Map<Character, Integer[]> map,char c, int k){
        if(!map.containsKey(c)) {
            map.put(c, new Integer[9]);
            Arrays.fill(map.get(c), 0);
        }
        if(map.get(c)[k] == 1) return false;
        else map.get(c)[k] = 1;
        return true;
    }

    public static boolean addToGridMap(Map<Character, Integer[]> gridMap,char c, int i, int j){
        if(!gridMap.containsKey(c)) {
            gridMap.put(c, new Integer[9]);
            Arrays.fill(gridMap.get(c), 0);
        }
        int gridBox = gridBox(i,j)-1;
        if(gridMap.get(c)[gridBox] == 1) return false;
        else gridMap.get(c)[gridBox] = 1;
        return true;
    }

    public static int gridBox(int i, int j){
        if(i<=2){
            return j <= 2 ? 1 : (j <= 5 ? 2 : 3);
        }else if(i>2 && i<=5){
            return j <= 2 ? 4 : (j <= 5 ? 5 : 6);
        }else{
            return j <= 2 ? 7 : (j <= 5 ? 8 : 9);
        }
    }
    /*
        ==============================================
     */

    public static boolean isValidSudoku_MY_optimized(char[][] board) {
        Map<Character, Integer[]> rowMap = new HashMap<>();
        Map<Character, Integer[]> colMap = new HashMap<>();
        Map<Character, Integer[]> gridMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    if(!addToMap(rowMap, c, i)) return false;
                    if(!addToMap(colMap, c, j)) return false;
                    int gridBox = (i / 3) * 3 + j / 3; //got it from the leetcode solution
                    if(!addToMap(gridMap,c,gridBox)) return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku_leetcode(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku_MY_optimized(board));
    }
}
