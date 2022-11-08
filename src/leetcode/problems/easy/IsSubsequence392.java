package leetcode.problems.easy;

public class IsSubsequence392 {
    public static void main(String[] args) {
        String s = "", t = "ahbgdc";
        int left = 0, right = 0;
        while(left < s.length() && right < t.length()){
            if(s.charAt(left) == t.charAt(right)) left++;
            right++;
        }
        System.out.println(left == s.length());
    }
}
