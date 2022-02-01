package leetcode.problems.easy;

import java.util.ArrayList;

public class SquaresOfASortedArray977_my {
    public static void main(String[] args) {
        //split into 2 arrays - one containing the negative numbers and the other containing the positive numbers.
        //Iterate on the array of negative number in reverse so that the result is a sorted array.
        //then merge our two sorted arrays.

        //Approch 2 - find first positive index and first negative index.
        //start two pointers - one from the first negative index and the other from the first positive index. Compare the modulo of the two
        //then square the smaller number and add to a new array and then increment the point of the number we squared and repeat the loop.

        //Approach 3 - similar to approach 2 - start 2 pointers from the two ends of the algorithm. Compare absolute value and add this to a queue.
        //Then move pointers and square and keep adding to the front of the queue.

        int[] nums = {-4,-1,0,0,0,0,0,0,0,0,0,3,10};
        int smallestNegativeIndex = -1;
        int firstPositiveIndex = -1;
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                firstPositiveIndex = i;
                break;
            }
        }

        for (int i = firstPositiveIndex-1; i >= 0; i--) {
            if(nums[i] < 0){
                smallestNegativeIndex = i;
                break;
            }
        }

        for (int i = smallestNegativeIndex+1; i < firstPositiveIndex; i++) {
            output.add(nums[i] );
        }

        int i = smallestNegativeIndex;
        int j = firstPositiveIndex;

        while(j<nums.length && i >= 0){
            if(nums[j] <= -1 * nums[i]){
                output.add(nums[j]*nums[j]);
                j++;
            }else if(nums[j] > -1 * nums[i]){
                output.add(nums[i]*nums[i]);
                i--;
            }
        }

        while(j<nums.length){
            output.add(nums[j]*nums[j]);
            j++;
        }

        while(i >= 0){
            output.add(nums[i]*nums[i]);
            i--;
        }
        int[] result = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            result[k] = output.get(k);
        }
    }
}
