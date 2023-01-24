package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public static boolean isIsomorphic(String s, String t) {
        return transform(s).equals(transform(t));
    }
    public static String transform(String s){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, i);
            builder.append(map.get(c));
            builder.append(" ");
        }

        System.out.println(builder.toString());
        return builder.toString();
    }
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s,t));

    }
}
