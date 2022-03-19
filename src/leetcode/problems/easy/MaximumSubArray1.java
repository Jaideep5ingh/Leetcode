package leetcode.problems.easy;

public class MaximumSubArray1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int current_array = nums[0];
        int max_array = nums[0];
        int best = 0;

        for (int i = 1; i < nums.length; i++) {
            current_array = Math.max(nums[i],current_array + nums[i]);

            max_array = Math.max(current_array, max_array);
//            best = Math.max(best, max_array);
        }
        System.out.println("Max Sub-array = " + max_array);
    }
}
