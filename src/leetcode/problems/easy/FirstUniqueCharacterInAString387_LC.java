package leetcode.problems.easy;

import java.util.HashMap;

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

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                System.out.println(i);
                System.exit(0);
            }

        }
    }
}
