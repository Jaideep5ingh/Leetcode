package leetcode.problems.easy;

public class GuessNumberHigherOrLower374 {
    public static int guessNumber(int n){
        int mid = -1;
        int left = 1, right = n;
        while(left<=right){
            mid = (left + right) >>> 1;
            int res = guess(mid+1);
            if(res == 0) return mid;
            if(res == 1) left = mid + 1 ;
            if(res == -1) right = mid -1 ;
        }
        return -1;
    }

    public static int guessNumber_TernarySearch(int n){
        int left = 1, right = n;
        while(left<=right){
            int mid1 = left + (right - left)/3;
            int mid2 = right - (right - left)/3;
            if(guess(mid1) == 0 ) return mid1;
            if(guess(mid2) == 0 ) return mid2;
            else if(guess(mid1) == -1) right = mid1 - 1;
            else if(guess(mid2) == 1) left = mid2 + 1;
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
//    Placeholder function to make things work
    private static int guess(int i) {
        return (int)(Math.random() + 10)/1;
    }

    public static void main(String[] args) {
        int n = 12;
        int index = guessNumber(n) ;
        System.out.println(index);
        System.out.println(guessNumber_TernarySearch(n));
    }
}
