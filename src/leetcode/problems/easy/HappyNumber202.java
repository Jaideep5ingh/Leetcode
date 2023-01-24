package leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
    public static boolean isHappy(int n) {
        if(n==1) return true;
        Set<Integer> set = new HashSet<>();
        while(set.contains(n) == false){
            set.add(n);
            n = n < 10 ? (int)Math.pow(n,2) : getSum(n);
        }
        return set.contains(1);
    }

    public static int getSum(int n){
        int result=0;
        while(n>0){
            int square = n%10;
            result += Math.pow(square,2);
            n/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(isHappy(n));
    }
}
