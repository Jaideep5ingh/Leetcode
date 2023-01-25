package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        if (nums1.length > nums2.length){
            intersection(nums2, nums1);
        }else {
            intersection(nums1,nums2);
        }
    }

    public static void intersection(int[] nums1, int [] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length ; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                result.add(nums2[i]);
                if (map.get(nums2[i]) > 1){
                    map.put(nums2[i],map.get(nums2[i]) -1);
                }else{
                    map.remove(nums2[i]);
                }
            }
        }
        System.out.println("" +  result);
    }

    public static int[] intersection_countSort(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        //Always treating nums1 as the shorter array.
        if(nums1Length  > nums2Length) return intersection_countSort(nums2, nums1);

        int[] countSort = new int[1001];
        for(int num : nums1) countSort[num]++;

        int[] result = new int[nums1Length];
        int counter=0;

        for (int i = 0; i < nums2Length; i++) {
            int num = nums2[i];
            if(countSort[num]>0){
                result[counter] = num;
                countSort[num]--;
                counter++;
            }
        }
        return Arrays.copyOf(result,counter);
    }
}
