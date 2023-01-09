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
    //This is a concept related to binary search since it cuts the space
    //in half at every step - half i in the loop. No need of mid here
    // as the basic concept behind binary search is cutting the space in
    //half running the program in log n time.
    public static double myPow_iterative(double x, int n) {
        if(x==0) return 1.0;
        if(n<0) {
            x = 1/x;
            n = Math.abs(n);//to convert negative value of n to positive.
        }
        double product=1.0;
        double current_product = x;
        for(int i = n; i > 0 ; i/=2){
            if(i%2==1) product= product * current_product;
            current_product = current_product * current_product;
        }
        return product;
    }
}
