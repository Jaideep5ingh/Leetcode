package leetcode.problems.easy;

public class Sqrt69 {
    public static int sqrt(int n){
        if(n<2) return n;

        int mid;
        int left = 1, right = n/2;
        long x;
        while(left <= right){
            mid = (left + right) >>> 1;
            x = (long)(mid * mid);
            if(x == n) return mid;
            else if(x < n) left = mid + 1;
            else right = mid - 1;
        }
        return right;
        //returning right to round off to the nearest integer. for example for n = 8, we would return 2.
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(sqrt(n));
    }
}
