package leetcode.problems.medium;

public class SearchInRotatedSortedArray33 {
    public static int search(int[] nums, int target){
        int mid;
        int left = 1, right = nums.length - 1;

        while(left <= right){
            mid = (left + right) >>> 1;
            if (nums[mid] == target) return mid;
            else if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid])   right = mid -1;
                else left = mid + 1;
            }else{
                if(target <= nums[right] && target > nums[mid]) left = mid +1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
