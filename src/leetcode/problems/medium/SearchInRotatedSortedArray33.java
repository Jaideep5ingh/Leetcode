package leetcode.problems.medium;

import java.util.Arrays;

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

    public static int[] nums;
    //METHOD 2 : Inflection point
    public static int searchRotatedArray_inflectionPoint(int[] nums, int target){
        SearchInRotatedSortedArray33.nums = nums;
        int rotated_index = findRotatedIndex(nums);
        if(nums[rotated_index] == target) return rotated_index;
        if(rotated_index == 0) return binarySearch(0, nums.length -1, target);
        if(nums[0] > target) return binarySearch(rotated_index,nums.length -1 , target);
        return binarySearch(0,rotated_index, target);
    }

    public static int findRotatedIndex(int[] nums){
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right){
            int pivot = (left + right) >> 1;
            if(nums[pivot] > nums[pivot+1]) return pivot;
            if(nums[pivot-1] > nums[pivot]) return pivot-1;

            if(nums[pivot] <= nums[left]) right = pivot-1;
            else left = pivot+1;
        }
        return -1;
    }

    public static int binarySearch(int left, int right,int target){
        while(left <= right){
            int mid = (left  + right) >>> 1;
            if(nums[mid] == target ) return mid;
            else if (nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,0,1,2,4};
        int target = 1;
        System.out.println(search(nums, target));
        System.out.println(searchRotatedArray_inflectionPoint(nums, target));
    }
}
