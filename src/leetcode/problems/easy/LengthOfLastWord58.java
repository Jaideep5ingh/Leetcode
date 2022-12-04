package leetcode.problems.easy;

public class LengthOfLastWord58 {
    public static void main(String[] args) {
        String s = "Hello World";
        s.trim();
        System.out.println(s.length() - s.lastIndexOf(" ")-1);
    }
}
