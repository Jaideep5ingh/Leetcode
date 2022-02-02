package leetcode.problems.easy;

import java.util.Arrays;

public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'H','e','l','l','o'};
        int left = 0; int right = s.length-1;

        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
