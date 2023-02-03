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
            char[] characterArray = word.toCharArray();
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
    public static String reverse(String s){
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) result.append(s.charAt(i));
        return result.toString();
    }

    public static String reverseWords_leetcode(String s) {
        StringBuilder result = new StringBuilder();
        int lastSpaceIndex = -1;
        for (int currentIndex = 0; currentIndex <= s.length(); currentIndex++) {
            if(currentIndex == s.length() || s.charAt(currentIndex) == ' '){
                int start = lastSpaceIndex+1;
                result.append(reverse(s.substring(start, currentIndex)));
                if(currentIndex!=s.length()) result.append(" ");
                lastSpaceIndex = currentIndex;
            }
        }
        return result.toString();
    }

    //TODO : INSPIRED BY 151. Reverse Words in a String
    public static String reverseWords_my(String s) {
        int left = 0, right = s.length()-1;
        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();

        while(s.charAt(left)==' ' && left<=right) {
            leftString.append(" ");
            ++left;
        }
        while(s.charAt(right)==' ' && left<=right) {
            rightString.append(" ");
            --right;
        }

        Stack<String> queue = new Stack<>();
        StringBuilder result = new StringBuilder();

        while(left<=right){
            char c = s.charAt(left);
            if(result.length()!=0 && c == ' '){
                queue.add(reverse(result.toString()) + " ");
                result.setLength(0);

            }else if (c!=' ') result.append(c);
            ++left;
        }
        queue.add(reverse(result.toString()));
        String str = String.join("", queue);
        return leftString + str + rightString;
    }

}
