package leetcode.problems.easy;

public class BinarySearch704 {
    public static int binarySearch_iteration(int[] nums, int target){
        int mid = -1;
        int left =0, right =nums.length-1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(target == nums[mid]) return mid;
//            Following code might help with time complexity :
//            else if(target == nums[left]) return left;
//            else if(target == nums[right]) return right;
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;

        }
        return -1;
    }

    public static int binarySearch_recursion(int[] nums, int target, int left, int right){
        if(left > right) return -1;
        int mid = (left + right) >>> 1;
        if(target == nums[mid]) return mid;
//            Following code might help with time complexity :
//            else if(target == nums[left]) return left;
//            else if(target == nums[right]) return right;
        else if(target > nums[mid]) return binarySearch_recursion(nums, target, mid +1, right);
        else return binarySearch_recursion(nums, target, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        int index = binarySearch_recursion(nums, target, 0, nums.length - 1) ;
        System.out.println(index);
    }
}
