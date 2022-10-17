package leetcode.problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "au";
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(ans);
        subString(s);

    }

    public static void subString(String s){
        int left =0, right =0 , res =0;
        Set<Character> set = new HashSet<>();
        while( right < s.length()){
            char r = s.charAt(right);
            if(set.contains(r)){
                while(set.contains(r)){
                    set.remove(s.charAt(left));
                    ++left;
                }
                set.add(s.charAt(left));
            }
            set.add(r);
            res = Math.max(res, set.size());
            ++right;
        }

        System.out.println("Result is L " + res);
    }
}
