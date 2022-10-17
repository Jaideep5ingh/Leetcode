package leetcode.problems.medium;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args)  {

        String s = "babad";
        int start = 0, end = 0;
        if (s.length() == 1) System.out.println("True");
        /*The idea is to treat each element(each i) as a center and find the max length of a palindrome from it as the center.
        len1 = palindrome with odd lengths have a single element in the center.
        len2 = palindrome with odd lengths have two elements in the center.
        start = half the length of the longest palindrome returned to the left of the current center(current i)
        end = half the length of the longest palindrome returned to the right of the current center(current i) */
        for (int i = 0; i < s.length(); i++) {
            int len1= palindromeAroundCenter(s, i, i);
            int len2 = palindromeAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end- start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        System.out.println(s.substring(start, end+1));
    }

    public static int palindromeAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;

        }
        return right - left - 1;
    }
}
