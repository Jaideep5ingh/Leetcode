package leetcode.problems.medium;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static int searchRange(int[] nums, int target, boolean isFirst){
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = (left  + right) >>> 1;
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == left || nums[mid-1] != target) return mid;
                    right = mid-1;
                }else{
                    if(mid == right || nums[mid+1] != target) return mid;
                    left = mid +1;
                }
            }else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {5,8,8,8,8,10}; //mid = 7, target = 1
        int target = 8;

        int firstOccurrence = searchRange(nums, target, true);
        if(firstOccurrence == -1){
            System.out.println("The element is not present in the array");
            System.exit(0);
        }
        int lastOccurrence = searchRange(nums, target, false);
        System.out.println("First Occurance = " + firstOccurrence + " and last occcurence is = " + lastOccurrence);
    }
}
