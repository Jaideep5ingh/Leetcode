package leetcode.problems.easy;

import java.util.Arrays;

public class SortArrayByParity905 {
    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length <=1 ) return nums;
        int left = 0, right = nums.length-1;
        while (left < right){
            boolean leftNum = nums[left]%2==1; //if true, number at left is odd
            boolean rightNum = nums[right]%2==0; //if true, number at right is even
            if(leftNum && rightNum) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }else if(!rightNum) --right;
            if(!leftNum) ++left;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,45,43,6,34,6,3456,343,36,8,7,23}; //mid = 7, target = 1
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }
}
