package leetcode.problems;

public class SubararySumEqualsK560 {
    public static void main(String[] args) {
        int[] nums = {3,4,7,2,-3,1,4,2};
        int k = 7;
        int sum = 0,count = 0;
        for (int i = 0,j=0; i < nums.length && j < nums.length; j++) {
            sum += nums[j];
            if(sum >= k){
                if(sum == k){
                    count++;
                }
                i++;
                j=i-1;
                sum = 0;
            }
        }
        System.out.println(count);
    }
}
