package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations46_Backtracking {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> output = permutations(nums);

        System.out.println(output);
    }

    public static List<List<Integer>> permutations(int[] nums){
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> numsArrayList = new ArrayList<>();

        for(int num : nums){
            numsArrayList.add(num);
        }

        int n = nums.length;
        backtrack(n, numsArrayList, output, 0);
        return output;
    }

    public static void backtrack(int n, List<Integer> nums, List<List<Integer>> output, int first ){
        if(first==n){
            output.add(new ArrayList<Integer>(nums));
        }

        for(int i = first; i< n; ++i){
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first+1);
            Collections.swap(nums, first, i);
        }
    }
}
