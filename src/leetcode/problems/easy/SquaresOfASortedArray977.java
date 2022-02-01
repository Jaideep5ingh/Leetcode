package leetcode.problems.easy;

import java.util.Arrays;

public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,0,0,0,0,0,0,0,0,3,10};
        int low = 0;
        int high = nums.length-1;
        int[] result = new int[nums.length];

        for (int i = nums.length-1; i >=0 ; i--) {
            if(Math.abs(nums[low]) >= Math.abs(nums[high])){
                result[i] = nums[low] * nums[low];
                low++;
            }else {
                result[i] = nums[high] * nums[high];
                high--;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
