package leetcode.problems.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void merge_my(int[] nums1, int m, int[] nums2, int n) {

        int left = m-1, right = n-1;
        int index = n + m - 1;
        while(left >= 0 && right >= 0){
            if(nums1[left] >= nums2[right]) nums1[index] = nums1[left--];
            else nums1[index] = nums2[right--];
            index--;
        }
        while (right > left) nums1[index--] = nums2[right--];
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge_leetcode(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1, right = n-1;
        for (int p = n+m-1;p>=0;p--){
            if(right < 0) break;
            if(left>=0 && nums1[left]>= nums2[right]) nums1[p] = nums1[left--];
            else nums1[p]= nums2[right--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge_my(nums, m, nums2, n);
    }
}
