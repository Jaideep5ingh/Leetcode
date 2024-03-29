package leetcode.problems.medium;

public class FindMinimumInRotatedSortedArray153 {
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] > nums[mid + 1]) return nums[mid+1];
            if(nums[mid - 1] > nums[mid]) return nums[mid];

            if(nums[mid] > nums[0]) left = mid + 1;
            else right = mid - 1;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
