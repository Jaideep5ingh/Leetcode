package leetcode.problems.medium;

public class MaxConsecutiveOnesII_487 {
    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = Integer.MIN_VALUE;
        int leftCount = 0, rightCount = 0;
        int lastZero = Integer.MIN_VALUE;
        boolean countLeft = true;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                if(lastZero < 0 ){
                    countLeft = false;
                    lastZero = i;
                }else{
                    max = Math.max(max, leftCount + rightCount+1);
                    leftCount = rightCount;
                    rightCount = 0;
                }
            }else {
                if (countLeft) ++leftCount;
                else ++rightCount;
            }
        }
        int last = lastZero < 0 ? leftCount + rightCount: leftCount + rightCount + 1;
        return Math.max(max, last);
    }


    public static void main(String[] args) {
        int[] heights = {1,0,0,1}; //mid = 7, target = 1
        System.out.println(findMaxConsecutiveOnes(heights));

    }
}
