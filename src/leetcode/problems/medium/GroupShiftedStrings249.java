package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < currentString.length(); j++) {
                char prev = currentString.charAt(j-1);
                char curr = currentString.charAt(j);
                int distance = calculateDistance(prev, curr);
                stringBuilder.append(distance).append(',');
            }

            String temp = stringBuilder.toString();
            if(!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(currentString);
        }
        return new ArrayList<>(map.values());
    }

    public static int calculateDistance(int prev, int curr){
        int prevVal = prev - 'a' + 1;
        int currVal = curr - 'a' + 1;
        int result = prevVal < currVal ? currVal - prevVal : (26-prevVal) +currVal;
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"abc","bcd","acef","xyz","az","ba","a","z"};
        System.out.println(groupStrings(strs));
    }
}
