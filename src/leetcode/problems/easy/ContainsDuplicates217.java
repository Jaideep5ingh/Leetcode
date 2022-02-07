package leetcode.problems.easy;

import java.util.HashMap;

public class ContainsDuplicates217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean result = false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                result = true;
                break;
            }
            map.put(nums[i],i);
        }
        System.out.println(result);
    }
}
