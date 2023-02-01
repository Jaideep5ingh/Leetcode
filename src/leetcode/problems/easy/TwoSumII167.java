package leetcode.problems.easy;

import java.util.Arrays;

public class TwoSumII167 {

    public static void main(String args[]) {
        int[] nums2 = {4,6,7,77,234,7854}; int target=84;
        System.out.println(Arrays.toString(twoSum(nums2, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] result = new int[]{-1,-1};
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            if(sum<target) ++left;
            else --right;
        }
        return result;
    }
}
