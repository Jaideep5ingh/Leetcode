package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> pCount = new HashMap<>();
        HashMap<Character,Integer> sCount = new HashMap<>();

        for(char c : p.toCharArray()) pCount.put(c, pCount.getOrDefault(c,0) + 1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch,0) + 1);

            if(i >= p.length()){
                char sChar = s.charAt(i - p.length());
                if(sCount.get(sChar) == 1) sCount.remove(sChar);
                else sCount.put(sChar, sCount.get(sChar) - 1);
            }

            if(pCount.equals(sCount)){
                result.add(i - p.length() + 1);
            }
        }

        System.out.println(result);
    }
}

