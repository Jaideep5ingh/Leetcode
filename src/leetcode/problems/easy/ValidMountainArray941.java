package leetcode.problems.easy;

public class ValidMountainArray941 {
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i < n-1 && (arr[i] < arr[i+1])) ++i;
        if(i==0 || i == n-1) return false;
        while(i < n-1 && (arr[i] > arr[i+1])) ++i;
        return true;
    }

    public static boolean validMountainArray_twoPointers(int[] arr) {
        if(arr.length < 3) return false;
        int l = 0;
        int r = arr.length - 1;
        while(l + 1 < arr.length - 1 && arr[l] < arr[l + 1]) l++;
        while(r - 1 > 0 && arr[r] < arr[r - 1]) r--;
        return l == r;
    }

    public static void main(String[] args) {
        int[] heights = {0,2,3,4,5}; //mid = 7, target = 1
        System.out.println(validMountainArray_twoPointers(heights));
    }
}
