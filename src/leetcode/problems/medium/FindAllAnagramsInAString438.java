package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class FindAllAnagramsInAString438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        int pLength = p.length();

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();

        for (char c : p.toCharArray()){
            pmap.put(c, pmap.getOrDefault(c,0)+1);
        }

        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c,0)+1);


            if (i >= pLength){
                c = s.charAt(i-pLength);
                if (smap.get(c)==1){
                    smap.remove(c);
                }else smap.put(c, smap.get(c)-1);
            }

            if (pmap.equals(smap)){
                output.add(i-pLength+1);
            }
        }
        System.out.println(output);
    }
}
