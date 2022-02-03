package leetcode.problems.medium;

public class SearchingRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        int target = 1;
        int left = 0;
        int right = nums.length-1;

        while(left <=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                System.out.println("The target is found at index =" + mid);
                break;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            else {
                if (target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
    }
}
