package leetcode.problems.medium;

public class HouseRobberDP198 {
    public static void main(String[] args) {
        int[] nums = {45,2,2,90};
        int n = nums.length;
        int results[] = new int[n + 1];
        results[n] = 0;
        results[n-1] = nums[n-1];

        for (int i = n-2; i>= 0; i--) {
            results[i]= Math.max(results[i+1],results[i+2] + nums[i] );
        }
        System.out.println(results[0]);
    }
}
