package leetcode.problems.easy;

public class BinarySearchOrSearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int mid = 0;
        int target = 3;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            mid = (left +right)/2;
            if (nums[mid] == target){
                System.out.println("Result was found at : " + mid);
                break;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println("Mid is : " + left);
    }
}
