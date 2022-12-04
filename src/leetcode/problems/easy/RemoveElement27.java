package leetcode.problems.easy;

public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int n = nums.length;
        int val = 2;
        int i =0;
        while(i<n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }
            else i++; //inside else because if the element at n-1 is also val, we need to send it at the back again
        }
        System.out.println(n);
    }
}
