package leetcode.problems.easy;

public class ArrayPartition_I_561 {
    public static int arrayPairSum(int[] nums) {
        int k = 10000;
        int[] count = new int[2 * k + 1];
        int maxSum = 0;
        boolean isEvenIndex = true;

        for(int num : nums) count[num + k ]++; //offset negative values if any
        for (int element = 0; element < 2 * k; element++) {
            while(count[element] > 0){
                maxSum+= (isEvenIndex ? element - k : 0); //element is the index in count and it will be the actual number in nums arrays
                //subtracting k here to get the original value of the element.
                isEvenIndex = !isEvenIndex;
                count[element]--;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
//        String jewels = "pwwkew";
        int[] nums = {6,2,6,5,1,2};
//        int[][] mat = {{1,2,3,8},{4,5,6,7},{7,8,9,6},{15,6,8,1}};
//        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] mat = {{1},{2}};
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"az","ba"};
//        int[] nums2 = {2,2};
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
//        char[] s = {'h','e','l','l','o'};
        System.out.println(arrayPairSum(nums));
    }
}
