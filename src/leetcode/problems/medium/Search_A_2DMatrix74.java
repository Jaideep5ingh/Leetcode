package leetcode.problems.medium;

public class Search_A_2DMatrix74 {
    public static boolean searchMatrix_my(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0) return false;
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1]) return false;
        for (int[] nums : matrix){
            if (target >= nums[0] && target <= nums[cols-1]) {
                if(binarySearch(nums, target)) return true;
                else break;
            }
        }
        return false;
    }


    public static boolean searchMatrix_leetcode(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0) return false;
        int left = 0, right = rows * cols - 1;
        while(left<=right){
            int mid = (left + right) >> 1;
            int midVal = matrix[mid/cols][mid%cols];
            if(midVal == target) return true;
            if(midVal < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }


    public static boolean binarySearch(int[] nums, int target){
        int left= 0, right = nums.length;
        while(left <= right){
            int mid = (left  + right) >>> 1;
            if(nums[mid] == target ) return true;
            else if (nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = {{1}};
        int target = 3;
        System.out.println(searchMatrix_my(matrix, target));
//        System.out.println(searchMatrix_leetcode(matrix, target));
    }
}
