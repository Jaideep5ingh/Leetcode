package leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInAStringIII557_my {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] string = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : string){
            char[] characterArray = convertToChar(word);
            result.append(reverse(characterArray,characterArray.length-1) + " ");
        }
        System.out.println(result.toString().trim());
    }

    public static String reverse(char[] s, int right){
        int left = 0;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reverse word : " + Arrays.toString(s));
        return Arrays.toString(s);
    }

    public static char[] convertToChar(String s){
        char[] characterArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            characterArray[i] = s.charAt(i);
        }
        return characterArray;
    }
}
