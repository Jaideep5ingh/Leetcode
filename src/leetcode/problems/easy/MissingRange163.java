package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRange163 {
    public static void main(String[] args) {
        int[] nums = {0,5,90,1000,35784};
//        int[] nums2 = {3,3};
        int upper = 36000, lower= -1;
        missingRange(nums, lower, upper);
    }

    public static void missingRange(int[] nums, int lower , int upper){
        List<String> result = new ArrayList<>();

        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i< nums.length) ? nums[i] : upper + 1;

            if(prev +1 <= curr - 1){
                result.add(formatRange(prev + 1 , curr-1));
            }
            prev = curr;
        }
        System.out.println(result);
    }
    public static String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }

    //Alternate more intuitive solution
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }

}
