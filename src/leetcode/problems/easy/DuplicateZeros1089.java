package leetcode.problems.easy;

import java.util.Arrays;

public class DuplicateZeros1089 {
    public static void duplicateZeroes(int[] nums){
        int dupes = 0;
        int length = nums.length-1;

        for (int left = 0; left <= length - dupes; left++) {
            if(nums[left] == 0){
                if(left == (length - dupes)){
                    nums[length] = 0;
                    --length;
                    break;
                }
                dupes++;
            }
        }
        int last = length - dupes;
        for (int i = last; i>=0; i--) {
            if(nums[i]==0){
                nums[i + dupes] = 0;
                dupes--;
                nums[i+dupes] = 0;
            }else nums[i+dupes] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0}; //mid = 7, target = 1
        duplicateZeroes(nums);

    }
}
