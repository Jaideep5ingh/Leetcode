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
}
