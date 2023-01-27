package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSum_II_454 {
    public static int fourSumCount_hashMap(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }
        for(int c : C){
            for(int d : D){
                count+=map.getOrDefault(-(c+d),0);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount_hashMap(nums1, nums2, nums3, nums4));
    }
}
