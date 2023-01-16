package leetcode.problems.easy;

public class MaxConsecutiveOnes465 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        //TODO: COULD CHECK FOR NULL ARRAY HERE BUT SINCE
        //TODO: THE CONSTRAINTS SAY THAT ARRAY SIZE WILL NOT LESS THAN 1
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count >= 0 && nums[i] == 1){
                count++;
                result = Math.max(count, result);
            }
            else count = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1}; //mid = 7, target = 1
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
