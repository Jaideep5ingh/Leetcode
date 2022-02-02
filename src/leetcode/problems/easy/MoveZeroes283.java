package leetcode.problems.easy;

import java.util.Arrays;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        for (int i = 0, j=1; j < nums.length; j++) {
            if (nums[i]==0 && nums[j]!=0){
                nums[i] = nums[j];
                nums[j] = 0;
            }

            if (nums[i] != 0){
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
