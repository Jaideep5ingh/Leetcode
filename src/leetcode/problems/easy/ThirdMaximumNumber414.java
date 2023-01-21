package leetcode.problems.easy;

public class ThirdMaximumNumber414 {
    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int thirdMax=Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length; i++) {
            if (max == nums[i] || secondMax == nums[i] || thirdMax == nums[i]) {
                continue;
            }
            if(nums[i] >= max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            }
            else if(nums[i] >= secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(nums[i] >= thirdMax) thirdMax = nums[i];
        }
        if (thirdMax == Long.MIN_VALUE) {
            int ans = (int) max;
            return ans;
        }

        int ans = (int) thirdMax;

        return thirdMax;
    }

    public static void main(String[] args) {
        int[] heights = {2,2,3,1}; //mid = 7, target = 1
        System.out.println(thirdMax(heights));
    }
}
