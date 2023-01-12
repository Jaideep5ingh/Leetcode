package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    public static int binarySearch(int[] nums, int target){
        int left= 0, right = nums.length - 1;
        while(left < right){
            int mid = (left  + right) >>> 1;
            if(nums[mid] == target ) return mid;
            else if (nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static List<Integer> findClosestElements_slidingWindow(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        if (n == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }

            return result;
        }

        int left = binarySearch(arr, x) - 1;
        int right = left-1;
        while(right - left - 1 < k){
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }
            if(right == arr.length  || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))  left--;
            else right++;
        }

        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5}; //mid = 7, target = 1
        int k = 4, x=3;
        System.out.println(findClosestElements_slidingWindow(nums, k, x));
    }
}
