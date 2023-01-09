package leetcode.problems.easy;

public class ArrangingCoins441 {
    public static int arrangeCoins(int num){
        int left= 0, right = num;
        while(left <= right){
            int mid = (left + right) >> 1;
            int curr = (mid*(mid+1))/2;
            if(curr == mid) return mid;
            else if(curr < num) left = mid+1;
            else right = mid - 1;
        }
        return (int)right;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
    }
}
