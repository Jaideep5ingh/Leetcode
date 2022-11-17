package leetcode.problems.easy;

public class LargestNumberAtLeastTwiceOfOthers747 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max)  {
                maxIndex = i;
                max = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(!(max >= 2* nums[i]) && i!=maxIndex){
                maxIndex = -1;
                break;
            }
        }

        System.out.println("The maximum index is : " + maxIndex);
    }
}
