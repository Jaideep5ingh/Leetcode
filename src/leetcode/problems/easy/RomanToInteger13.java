package leetcode.problems.easy;

import java.util.HashMap;

public class RomanToInteger13 { public static void main(String[] args) {
    HashMap<Character,Integer> roman = new HashMap<>();
    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);

    String s = "DXCI";
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int value = roman.get(c);
        if(i!=s.length()-1 && (roman.get(s.charAt(i)) < roman.get(s.charAt(i+1)))){
            result+=roman.get(s.charAt(i+1)) - roman.get(s.charAt(i));
            i++;
        }
        else {
            result+=roman.get(s.charAt(i));
        }
    }
    System.out.println(result);
}
}
