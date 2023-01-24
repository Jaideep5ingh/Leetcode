package leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        if(nums1Length  > nums2Length) return intersection(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        int[] result = new int[nums1Length];
        int j=0;
        for (int i = 0; i < nums2Length; i++) {
            int num = nums2[i];
            if(map.containsKey(num)){
                int count = map.get(num) == 0 ?  0: map.get(num);
                if(count>0) {
                    result[j] = (num) ;
                    j++;
                    map.put(num, 0);//all intersection elements should appear once in the final array
                }
            }
        }
        return Arrays.copyOf(result,j);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}; //mid = 7, target = 1
        int[] nums2 = {2,2}; //mid = 7, target = 1
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}
