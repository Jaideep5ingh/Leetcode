package leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement424 {


    public static int characterReplacement_slow(String s, int k) {
        Set<Character> allLetters = new HashSet<>();

        int max = 0;
        for (int i = 0; i < s.length(); i++) allLetters.add(s.charAt(i));

        for(char letter : allLetters){
            int start = 0;
            int count = 0;
            for (int end = 0; end < s.length(); end++) {
                if(s.charAt(end) == letter) count++;
                while(!isWindowValid(start, end, count, k)){
                    if(s.charAt(start) == letter) count--;
                    start++;
                }
                max = Math.max(max, end + 1 - start);
            }
        }
        return max;
    }

    private static Boolean isWindowValid(int start, int end, int count, int k) {
        return end + 1 - start - count <= k;
    }

    public static int characterReplacement_fast(String s, int k){
        int[] frequencyMap = new int[26];
        int start =0;
        int maxLength = 0;
        int maxFrequency = 0;

        for (int end = 0; end < s.length(); end++) {
            int currentChar = s.charAt(end) - 'A';
            frequencyMap[currentChar]++;
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentChar]);

            Boolean isValid = end + 1 - start - maxFrequency <= k;
            if(!isValid){
                int outGoingChar = s.charAt(start++) - 'A';
                frequencyMap[outGoingChar]--;
            }
            maxLength = end + 1 - start;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String hay = "AABABBA";
        int k = 1, x=3;
        System.out.println(characterReplacement_slow(hay, k));
        System.out.println(characterReplacement_fast(hay, k));
    }

    //TODO : my attempt - does not work
    public static int characterReplacement_my(String s, int k) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int original = k;
        int left = 0,right = 0;
        int max = 0;
        int count =0;
        char curr = s.charAt(0);
        while(right < s.length()){
            if (s.charAt(right) == curr) ++count;
            else if (s.charAt(right) != curr && k > 0){
                --k;
                ++count;
            }
            else if (s.charAt(right) != curr && k <= 0){
                max = Math.max(count, max);
                count = 0;
                k = original;
                while(s.charAt(left) == curr) ++left;
                curr = s.charAt(left);
                right = left;
            }
            ++right;
        }

        return Math.max(max, count);
    }

}
