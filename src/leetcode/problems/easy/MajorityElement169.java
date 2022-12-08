package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public static int majorityElement_bitwise(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            // Count how many numbers have this bit set.
            int bit_count = 0;
            for (int num : nums) {
                int test = num & bit;
                if ( test != 0) {
                    bit_count++;
                }
            }

            // If this bit is present in more than n / 2 elements
            // then it must be set in the majority element.
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }
        return majority_element;
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int majority_element = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2)
                majority_element = entry.getKey();
        }

        return majority_element;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement_bitwise(nums));
        System.out.println(majorityElement(nums));
    }
}
