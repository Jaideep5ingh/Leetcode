package leetcode.problems.easy;

import java.util.*;

public class ContainsDuplicateII_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; ++i){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate_mySolution(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++){
            ArrayList<Integer> temp = map.get(nums[i]);
            if(temp.size()>1){
                for (int j = 0; j < temp.size()-1; j++) {
                    if(Math.abs(temp.get(j) - temp.get(j+1)) <=k) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
