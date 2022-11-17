package leetcode.problems.easy;

//Question same as : https://leetcode.com/problems/find-the-middle-index-in-array/
public class FindPivotIndex724 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int sum =0;
        int leftSum =0;
        for(int i : nums) sum+=i;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                System.out.println("Middle Index is : " + i + " and element is : " +  nums[i]);
                System.exit(0);
            }
            leftSum += nums[i];
        }
    }
}
