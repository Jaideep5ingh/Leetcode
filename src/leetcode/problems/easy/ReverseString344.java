package leetcode.problems.easy;

import java.util.Arrays;

public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'H','e','l','l','o'};
        char[] s2 = {'H','e','l','l','o'};
        char[] s3 = {'H','e','l','l','o'};
        int left = 0; int right = s.length-1;

        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
        reverseString1(s2);
        reverseString2(s3);
    }

    public static void reverseString1(char[] s) {
        helper1(s,0);
        System.out.println(Arrays.toString(s));
    }

    public static void helper1(char[] s, int i) {
        if(i >= s.length) return;
        char curr = s[i];
        helper1(s, i+1);
        s[s.length - i - 1] = curr;
    }

    public static void reverseString2(char[] s) {
        helper2(s,0, s.length - 1);
        System.out.println(Arrays.toString(s));
    }

    public static void helper2(char[] s, int start, int end) {
        if(start >= end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper2(s, start+1, end-1);
    }
}
