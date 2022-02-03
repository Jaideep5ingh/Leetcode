package leetcode.problems.easy;

import java.util.ArrayList;
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
}
