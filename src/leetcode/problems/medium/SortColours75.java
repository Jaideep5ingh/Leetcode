package leetcode.problems.medium;

//DUTCH NATIONAL FLAG PROBLEM

public class SortColours75 {
    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        int curr = 0, p0 = 0, p2 = nums.length - 1;
        while(curr <= p2){
            if(nums[curr] == 2){
                int temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = temp;
                p2--;
            }else if(nums[curr] == 0){
                int temp = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = temp;
                p0++;
                curr++;
            }else curr++;
        }

        for(int i : nums) System.out.print(i + " ");
    }
}
