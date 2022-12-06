package leetcode.problems.easy;

public class FirstBadVersion278 {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

//    Only a placeHolder version
    private static boolean isBadVersion(int mid) {
        return true;
    }
}
