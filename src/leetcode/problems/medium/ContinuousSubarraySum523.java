package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum523 {

    public static boolean contSubarraySum(int[] nums, int k){
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0,0));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum % k))
                map.put(sum % k, i+1);
            else if (map.get(sum % k) < i) //meaning that the current i is after the index at which the remainder was found.
//                Even if it is i-1, the sub-array would be 2 elements long and thus we can return true;
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
//        int n = arr.length;
//        int[] result = new int[n];
//        int[] speed = {3,2};
        int k = 10;
        System.out.println(contSubarraySum(nums, k));
//        System.out.println(subarraySum_cummulativeSum(nums, k));
    }
}
