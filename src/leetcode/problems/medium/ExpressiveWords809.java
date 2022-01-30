package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressiveWords809 {

    public static int check(HashMap<Character, Integer> hashMap , HashMap<Character, Integer> wordsMap){
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        int count = 1;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue()<3 && entry.getValue()!= wordsMap.get(entry.getKey()) ||
                    (wordsMap.containsKey(entry.getKey()) && entry.getValue() < wordsMap.get(entry.getKey()))){
                System.out.println("The frequency of " + entry.getKey() + " doesn't match in the two strings");
                count = 0;
                break;
            }
        }
        return count > 0 ? 1:0;
    }

    public static void main(String args[]) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        int result=0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i),0 )+1);
        }

        for (int i = 0; i < words.length; i++) {
            wordsMap.clear();
            for (int j = 0; j < words[i].length(); j++) {
                if(!hashMap.containsKey(words[i].charAt(j))){
                    break;
                }
                wordsMap.put(words[i].charAt(j), wordsMap.getOrDefault(words[i].charAt(j),0 )+1);
            }
            if(hashMap.keySet().equals(wordsMap.keySet())){
                result+=check(hashMap,wordsMap);
            }

        }
        System.out.println("Final Result = " + result);

    }
}
