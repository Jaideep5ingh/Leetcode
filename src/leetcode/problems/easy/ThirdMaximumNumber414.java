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

    public int thirdMax_myAttempt(int[] nums) {
        //TODO : Doesn't work
        //TODO : the attempt here was to find the order in first three elements and go from there.
        //TODO : need to handle same elements like 2,2 in the array
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int index = 0;
        int secondMax=nums[1];
        int thirdMax=nums[2] ;
        int max = Math.max(nums[0],Math.max(nums[1],nums[2]));
        if(max == nums[0]){
            secondMax = Math.max(nums[1], nums[2]);
            thirdMax = Math.min(nums[1], nums[2]);
        }
        else if(max == nums[1]) {
            secondMax = Math.max(nums[0], nums[2]);
            thirdMax = Math.min(nums[0], nums[2]);
        }
        else {
            secondMax = Math.max(nums[0], nums[1]);
            thirdMax = Math.min(nums[0], nums[1]);
        }

        for (int i = 3 ; i < nums.length; i++) {
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

        return thirdMax;
    }

    public static void main(String[] args) {
        int[] heights = {2,2,3,1}; //mid = 7, target = 1
        System.out.println(thirdMax(heights));
    }
}
