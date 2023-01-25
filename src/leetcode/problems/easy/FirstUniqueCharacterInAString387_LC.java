package leetcode.problems.easy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString387_LC {
    public static void main(String[] args) {
        String s = "loveleetcode";
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        System.out.println(firstUniqChar_array(s));
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                System.out.println(i);
                System.exit(0);
            }
        }

    }

    public static int firstUniqChar_array(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(frequency[c - 'a'] == 1) return i;
        }
        return -1;
    }
}
