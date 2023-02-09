package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings271 {
    int random = (int) (Math.random()*769 + 12564);
    String delimeter = "¶¶" + String.valueOf(random) + "§§";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() == 0) return Character.toString((char)258);

        StringBuilder result = new StringBuilder();
        for (String s : strs){
            result.append(s + delimeter);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s.equals(Character.toString((char)258)) || s.equals(delimeter)) return new ArrayList<>();
        String[] strs = s.split(delimeter);
        return new ArrayList<>(Arrays.asList(strs));
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings271 o=new EncodeAndDecodeStrings271();
        String[] strs = {"Hello", "World"};
        System.out.println((o.encode(new ArrayList(Arrays.asList(strs)))));
        System.out.println(o.decode((o.encode(new ArrayList(Arrays.asList(strs))))));
    }

}
