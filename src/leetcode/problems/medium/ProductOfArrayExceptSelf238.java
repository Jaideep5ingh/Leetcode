package leetcode.problems.medium;

public class ProductOfArrayExceptSelf238 {

    public static  void productExceptSelf(int[] nums) {
        int n = nums.length;
//        given that the length of nums is atleast 2
//        so not checking for num.length == 1
        int[] leftAns = new int[n];
        leftAns[0] = 1;

        int[] rightAns = new int[n];
        rightAns[n-1] = 1;

        for (int i = 1; i < n; i++) {
            leftAns[i] = leftAns[i-1] * nums[i-1];
        }

        for (int i = n-2 ; i>=0; i--) {
            rightAns[i] = rightAns[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(leftAns[i] * rightAns[i] + " ");
        }
    }

    public static  void productExceptSelf_constantSpace(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        int R = 1;
        for (int i = n-1; i>=0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]  + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf_constantSpace(nums);
    }

}
