package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,4,5,5,2,6,6,7,7};
//        int[] nums2 = {3,3};
        //hashset -> 2 loops
        System.out.println("Result of Map function : " + singleMap(nums));
        System.out.println("Result of Bit function : " + singleBit(nums));
    }

    public static int singleMap(int[] nums){
        int result = 0;
        Map<Integer, Integer> set = new HashMap<>();
        for(int n : nums){
            set.put(n, set.getOrDefault(n, 0) + 1);
//            get, put, putifAbsent, getOrDefault;

        }

        for(Map.Entry<Integer, Integer> entry : set.entrySet()){
            if(entry.getValue() == 1){
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static int singleBit(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
