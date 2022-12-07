package leetcode.problems.medium;

import java.util.HashMap;

public class SubararySumEqualsK560 {
    public static int subarraySum(int[] nums, int k){
        int count = 0, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static int subarraySum_cummulativeSum(int[] nums, int k){
        int count = 0, sum=0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
            for (int start = 0; start < nums.length; start++) {
                for (int end = start+1; end <= nums.length ; end++) {
                    if(sums[end] - sums[start] == k )
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6};
        int k = 6;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum_cummulativeSum(nums, k));
    }
}

//54189456
