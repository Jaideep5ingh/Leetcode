package leetcode.problems;

public class ReverseInteger7_my {
    public static void main(String args[]) {
        int x = 2147483647; //2147483647  7463847421
        String s = Integer.toString(x);
        String reverse ="";
        for (int i=s.length()-1; i>=0; i--)
        {
            reverse += s.charAt(i); //extracts each character
        }
        x = Double.valueOf(reverse) > Integer.MAX_VALUE ? 0: Integer.valueOf(reverse);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(x);
    }
}
