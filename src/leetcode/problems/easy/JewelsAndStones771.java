package leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones771 {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int result= 0;
        for(char c : jewels.toCharArray()) set.add(c);
        for(char c : stones.toCharArray()) if (set.contains(c)) result++;
        return result;
    }

    public static int numJewelsInStones_array(String jewels, String stones) {
        int[] counts = new int[52]; //first 26 = lower case. next 26 //uppercase
        int result= 0;
        for(char c : stones.toCharArray()) {
            if(Character.isUpperCase(c)) counts[c - 'A' + 26]++;
            if(Character.isLowerCase(c)) counts[c - 'a']++;
        }
        for(char c : jewels.toCharArray()) {
            if(Character.isUpperCase(c)) result += counts[c - 'A' + 26];
            if(Character.isLowerCase(c)) result += counts[c - 'a'];
        }

        return result;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
        System.out.println(numJewelsInStones_array(jewels, stones));
    }
}
