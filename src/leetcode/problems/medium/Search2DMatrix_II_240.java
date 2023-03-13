package leetcode.problems.medium;

public class Search2DMatrix_II_240 {

    static int[][] matrix;
    static int target;

    public static boolean searchRec(int left,int up, int right, int down ){
        if(left > right || up > down ) return false;
        if(matrix[up][left] > target || matrix[down][right] < target) return false;

        int mid = left + (right - left)/2;
        int row = up;
        while(row <=down && matrix[row][mid] <= target){
            if(matrix[row][mid] == target) return true;
            ++row;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid + 1, up, right , row -1);
    }
    public static void main(String[] args) {
        matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        target = 5;
        if(matrix == null || matrix.length == 0) {
            System.exit(0);
//            return false;
        }
        searchRec(0,0 ,matrix[0].length-1, matrix.length-1);
//        return searchRec(0,0 ,matrix[0].length-1, matrix.length-1);
    }
}
