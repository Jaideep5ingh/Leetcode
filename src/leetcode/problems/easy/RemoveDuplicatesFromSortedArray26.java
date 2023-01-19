package leetcode.problems.easy;

public class RemoveDuplicatesFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==1) return 1;
        int pointer = 1;
        for (int i = 1; i < nums.length; i++)  {
            if (nums[i]!=nums[i-1]) nums[pointer++] = nums[i];
        }
        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; //mid = 7, target = 1
        System.out.println(removeDuplicates(nums));

    }
}
