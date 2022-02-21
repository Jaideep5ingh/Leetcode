package Revision.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        int[] alphabets = new int[26];
        for (String s: strs){
            Arrays.fill(alphabets,0);
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                alphabets[chars[i] - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(alphabets[i]);
            }
            if (!map.containsKey(stringBuilder.toString())){
                map.put(stringBuilder.toString(), new ArrayList<String>());
            }
           map.get(stringBuilder.toString()).add(s);
        }

        System.out.println(map.values());
    }
}
