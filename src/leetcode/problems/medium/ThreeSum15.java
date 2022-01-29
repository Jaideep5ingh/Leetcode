package leetcode.problems.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums  = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int k = i+1, j= nums.length-1;
            while (k<j){
                if(nums[i] + nums[k] + nums[j] == 0){
                    System.out.println("Requireed indices are - " + i + " and " + j);
                    break;
                }else if(nums[i] + nums[k] + nums[j] > 0){
                    j--;
                }else if(nums[i] + nums[k] + nums[j] < 0){
                    i++;
                }
            }
        }
    }
}
