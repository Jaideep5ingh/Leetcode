package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstUniqueCharacterInAString387_my {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int min = -1;
        int result = 0;

        HashMap<Character, Integer> frequency = new HashMap<>();
        HashMap<Character, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i),0) +1 );
            if (indices.get(s.charAt(i))==null){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                indices.put(s.charAt(i),temp);
            }else {
                indices.get(s.charAt(i)).add(i);
            }
        }
        for (Character c : frequency.keySet()){
            int firstIndex = indices.get(c).get(0);
            if(frequency.get(c) == 1){
                if (firstIndex < min || min == -1){
                    min = firstIndex;
                }
            }
        }
        System.out.println(frequency);
        System.out.println(indices);
        System.out.println(min);
    }
}
