package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInArray448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int num : nums) set.add(num);

        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) result.add(i);
        }
        return result;
    }
    public static List<Integer> findDisappearedNumbers_array(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>0) result.add(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers_array(nums));

    }
}
