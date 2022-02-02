package leetcode.problems.medium;

import java.util.Arrays;

public class RotateArrays189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 5;
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums, k, nums.length-1);
        System.out.println("The new array : " + Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int startingIndex, int lastIndex){
        for (int i = startingIndex; i < lastIndex; i++) {
            int temp = nums[i];
            nums[i] = nums[lastIndex];
            nums[lastIndex]= temp;
            lastIndex--;
        }
    }
}
