package leetcode.problems.medium;

public class Pow_x_n_50 {
    public static void main(String[] args) {
        double x = 2;
        int n = 4;

        if (n<0){
            x=1/x;
            n = n;
        }
        System.out.println(fasterPow(x,n));
    }

    private static double fasterPow(double x, int n) {
        double result = 0.0;
        if (n==0){
            return 1.00;
        }
        double half = fasterPow(x,n/2);
        if(n%2==0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
