package leetcode.problems.easy;

import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if( digits[i] == 9) digits[i] = 0;
            else {
                digits[i]++;
                System.out.println(Arrays.toString(digits));
                System.exit(0);
            }
        }
        digits = new int[n+1];
        digits[0] = 1;
        System.out.println(Arrays.toString(digits));
    }
}
