package leetcode.problems.easy;

public class NthTribonacciNumber1137 {
    public static void main(String[] args) {
        int n = 0;
        int[] tribonacci = new int[n+1];

        if(n>=1) {
            tribonacci[1] = 1;
            if (n >= 2) {
                tribonacci[2] = 1;
            }
        }
        for (int i = 3; i <= n ; i++) {
            tribonacci[i] = tribonacci[i-1] +  tribonacci[i-2] + tribonacci[i-3];
        }
        System.out.println(tribonacci[n]);
    }
}
