package leetcode.problems.other;

public class PrimeNumber {
    public static void main(String[] args) {
        int x = 53;

        if (x==0) System.exit(0);

        for (int i = 2; i < x/2; i++) {
            if (x%i == 0){
                System.out.println("The number if divisible by " + i +" and is not a prime");
                System.exit(0);
            }
        }
        System.out.println("The number is a prime");
    }
}
