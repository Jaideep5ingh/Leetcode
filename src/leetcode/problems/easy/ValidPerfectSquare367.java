package leetcode.problems.easy;

public class ValidPerfectSquare367 {
    public static boolean isPerfectSquare(int num){
        long left= 0, right = num/2;
        while(left <= right){
            long mid = (left  + right) >>> 1;
            long midSquare  = mid * mid;
            if(midSquare == num) return true;
            else if(midSquare < num) left = mid + 1;
            else right = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
