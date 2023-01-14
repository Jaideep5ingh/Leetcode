package leetcode.problems.hard;

public class MedianOfTwoSortedArrays4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = m;
        int half = (m + n + 1) >> 1;

        while(left <= right){
            int idx_1 = (left + right) >> 1;
            int idx_2 = half - idx_1;

            int left1= idx_1 > 0 ? nums1[idx_1-1] : Integer.MIN_VALUE;
            int right1= idx_1 < m ? nums1[idx_1] : Integer.MAX_VALUE;
            int left2= idx_2  > 0 ? nums2[idx_2-1] : Integer.MIN_VALUE;
            int right2= idx_2 < n ? nums2[idx_2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                if((m+n) % 2 ==0 ) return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                else return Math.max(left1, left2);
            }else if(left1 > right2) right = idx_1 - 1;
            else left = idx_1 + 1;
        }
        return -1.0;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4}; //mid = 7, target = 1
        int[] nums3 = {6,7,8}; //mid = 6, target = 4
        System.out.println(findMedianSortedArrays(nums, nums3));

    }
}
