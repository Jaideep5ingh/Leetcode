package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == '1'){
                    islands++;
                    grid[r][c] = '0'; //Mark as visited

                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r*cols + c);
                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / cols;
                        int col = id % cols;

                        if (row-1 >=0 && grid[row-1][col] == '1'){
                            neighbors.add((row-1)*cols + col);
                            grid[row-1][col] = '0'; //marking visited
                        }
                        if (row+1 < rows && grid[row+1][col] == '1'){
                            neighbors.add((row+1)*cols + col);
                            grid[row+1][col] = '0'; //marking visited
                        }
                        if (col -1 >=0 && grid[row][col-1] == '1'){
                            neighbors.add(row*cols + col-1);
                            grid[row][col-1] = '0'; //marking visited
                        }
                        if (cols+1 < cols && grid[row][col+1] == '1'){
                            neighbors.add((row*cols) + col+1);
                            grid[row][col+1] = '0'; //marking visited
                        }
                    }
                }
            }
        }
        System.out.println(islands);
    }
}
