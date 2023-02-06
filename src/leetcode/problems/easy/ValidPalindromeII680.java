package leetcode.problems.easy;


//Some test cases failed - need to implement another function to check this.
public class ValidPalindromeII680 {
    public static void main(String[] args) {
        String s = "abc";
        if (s.length()==0) System.exit(0);
        int left = 0;
        int count=0;
        int right = s.length()-1;
        while(left <= right){
            if ((s.charAt(left) != s.charAt(right))){
                count++;
            }
            if (count>1){
                System.out.println("String cannot be a pallindrome by remove atmost one character");
                System.exit(0);
            }
            left++;
            right--;
        }
        System.out.println("String can be a palindrome by remove at most one character");
    }

    //TODO : DOES NOT WORK. JUST RECORDING MY ATTEMPT
    public static boolean validPalindrome_MY(String s) {
        if(s.length() == 1) return true;
        boolean charRemoved = false;
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                if(charRemoved) return false;
                if(left - right  + 1== 0 ) return true;
                else if(s.charAt(left+1) == s.charAt(right)) {
                    charRemoved = true;
                    ++left;
                }else if (s.charAt(left) == s.charAt(right-1)) {
                    charRemoved = true;
                    --right;
                }
                else return false;
            }else ++left; --right;
        }
        return true;
    }
}
