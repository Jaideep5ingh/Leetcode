package leetcode.problems.easy;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void merge_my(int[] nums1, int m, int[] nums2, int n) {
        if(n<1) return;

        int left = m-1, right = n-1;
        int index = n + m - 1;
        while(left >= 0 && right >= 0){
            if(nums1[left] >= nums2[right]){
                nums1[index] = nums1[left];
                left--;
            }else {
                nums1[index] = nums2[right];
                right--;
            }
            index--;
        }
        while (right > left) {
            nums1[index] = nums2[right];
            right--;
            index--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int[] nums2 = {0};
        int m = 1;
        int n = 1;
        merge_my(nums, m, nums2, n);
    }
}
