package leetcode.problems.medium;

public class MinimumSizeSubarraySum209 {
    public static int minSubArrayLen_my_not_working(int target, int[] nums) {
        int left = 0, right = 1;
        int min = Integer.MAX_VALUE;//change according to required value when no such combination is found.
        int windowSum=nums[left];
        while(right<nums.length){
            if(nums[right]==target) return 1;
            windowSum +=nums[right];
            if(windowSum == target){
                min = Math.min(min, right - left - 1);
                windowSum -= nums[left++];
                if(left == right && right+1<nums.length)++right;
            }else if(windowSum < target) right++;
            else {
                if(windowSum == target) min = Math.min(min, right - left - 1);
                windowSum=-nums[left++];
                if(left == right && right+1<nums.length)++right;
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }

    public static int minSubArrayLen_my_working(int target, int[] nums) {
        int left = 0, right = 1;
        int min = Integer.MAX_VALUE;//change according to required value when no such combination is found.
        int windowSum=nums[left];
        if(windowSum>=target) return 1;
        while(right<nums.length){
            windowSum +=nums[right];
            while(windowSum >=target){
                min = Math.min(min, right + 1 - left);
                windowSum-=nums[left++];
            }
            ++right;
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }

    public static int minSubArrayLen_leetcode(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;//change according to required value when no such combination is found.
        int windowSum=0;
        for (int i = 0; i < nums.length; i++) {
            windowSum+= nums[i];
            while(windowSum >= target){
                min = Math.min(min, i + 1 -left);
                windowSum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 3};
        int target = 6;
        System.out.println(minSubArrayLen_leetcode(target, nums));

    }
}
