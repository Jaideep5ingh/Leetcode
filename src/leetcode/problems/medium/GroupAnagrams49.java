package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, ArrayList<String>> ans = new HashMap<>();

        int[] alphabet = new int[26];
        for (String s : strs){
            Arrays.fill(alphabet,0);
            char[] characters = s.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                alphabet[characters[i]-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                key.append("#");
                key.append(alphabet[j]);
            }
            if (!ans.containsKey(key.toString())){
                ans.put(key.toString(), new ArrayList<>());
            }
            ans.get(key.toString()).add(s);
        }
        System.out.println(ans.values());
    }
}
