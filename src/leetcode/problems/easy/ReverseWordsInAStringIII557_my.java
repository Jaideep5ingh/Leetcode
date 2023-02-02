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

    public static String reverseWords_split(String s) {
        if(s.length() == 0 || s.equals("")) return "";
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length-1; i >= 0 ; i--) {
            if(words[i].equals("")) continue;
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }

    public static String reverseWords_deque(String s) {
        s = s.trim();
        if(s.length() == 0 || s.equals("")) return "";
        int left =0, right = s.length()-1;
        ArrayDeque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while( left <= right) {
            char c = s.charAt(left);
            if(word.length()!=0 && c == ' '){
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if(c!=' ') word.append(c);
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ",  d);
    }

    public static String reverseWords_stack(String s) {
        s = s.trim();
        if(s.length() == 0 || s.equals("")) return "";
        int left =0, right = s.length()-1;

        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();

        while( left <= right) {
            char c = s.charAt(left);
            if(word.length()!=0 && c == ' '){
                stack.push(word.toString());
                word.setLength(0);
            }else if(c!=' ') word.append(c);
            ++left;
        }

        stack.push(word.toString());
        while(!stack.isEmpty()) result.append(stack.pop() + " ");
        return result.toString().trim();
    }
}
