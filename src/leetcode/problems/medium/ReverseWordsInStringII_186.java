package leetcode.problems.medium;

import java.util.Arrays;

public class ReverseWordsInStringII_186 {
    public static void reverseWords(char[] s) {
        int len = s.length;
        int left=0, right = len-1;
        int lastSpaceIndex = -1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; --right;
        }
        for (int currentIndex = 0; currentIndex <= len; currentIndex++) {
            if(currentIndex == len || s[currentIndex] == ' '){
                int start = lastSpaceIndex+1;
                int end = currentIndex-1;
                while(start < end){
                    char temp = s[start];
                    s[start] = s[end];
                    s[end]=temp;
                    ++start; --end;
                }
                lastSpaceIndex=currentIndex;
            }
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] jewels = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(jewels);

    }
}
