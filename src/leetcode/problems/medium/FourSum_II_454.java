package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSum_II_454 {
    static int[][] lists;

    public static int fourSumCount_hashMap(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }
        for(int c : C){
            for(int d : D){
                count+=map.getOrDefault(-(c+d),0);
            }
        }
        return count;
    }

    public static int fourSumCount_generalized_solution(int[] A, int[] B, int[] C, int[] D) {
        lists =  new int[][]{A, B, C, D};
        int k = lists.length;
        Map<Integer, Integer> left = sumCount(0, k/2);
        Map<Integer, Integer> right = sumCount(k/2, k);
        int res = 0;
        for(int s : left.keySet()){
            res = res + (left.get(s) * right.getOrDefault(-s, 0));
        }
        return res;
    }

    public static Map<Integer, Integer> sumCount(int start, int end){
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0,1);
        for (int i = start; i < end; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int a : lists[i]){
                for(int total : count.keySet()){
                    map.put(total + a, map.getOrDefault(total + a, 0) + count.get(total));
                }
            }
            count = map;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount_hashMap(nums1, nums2, nums3, nums4));
    }
}
