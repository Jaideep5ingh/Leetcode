package leetcode.problems.medium;

public class FindPeakElement162 {
    static int leftNum;
    static int rightNum;

    public static int findPeakElement_my(int[] nums, int left, int right) {
        if(left < 0 || right > nums.length-1 || left>right) return -1;
        int mid = (left + right) >> 1;

        leftNum = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
        rightNum = mid == nums.length-1 ? Integer.MIN_VALUE : nums[mid+1];

        if(nums[mid] > leftNum && nums[mid] > rightNum) return nums[mid];
        int leftSubArray = findPeakElement_my(nums, left, mid-1);
        int rightSubArray = findPeakElement_my(nums, mid+1, right);

        return leftSubArray!=-1 ? leftSubArray : (rightSubArray!=-1 ? rightSubArray : -1 );
//        return rightSubArray!=-1 ? rightSubArray : (leftSubArray!=-1 ? leftSubArray : -1);
    }

    public static void main(String[] args) {
//        int[] nums4 = {1,2,1,3,5,6,4}; //mid = 6, target = 4
        int[] nums4 = {1,2}; //mid = 6, target = 4
        System.out.println(findPeakElement_my(nums4,0, nums4.length-1));
    }
}
